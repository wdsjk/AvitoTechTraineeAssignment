package wdsjk.project.avitotechtrainee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wdsjk.project.avitotechtrainee.entity.Chat;
import wdsjk.project.avitotechtrainee.entity.Message;
import wdsjk.project.avitotechtrainee.repository.MessageRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String save(Message message) {
        message.setCreated_at(LocalDate.now());

        messageRepository.save(message);
        return String.valueOf(message.getMessageId());
    }

    public Message getMessageByChatId(Long chatId) {
        List<Message> allMessages = messageRepository.findAll();

        for (Message message : allMessages) {
            if (message.getChat().getChatId().equals(chatId)) {
                return message;
            }
        }
        return null;
    }

    public List<Message> getAllChatMessages(Chat chat) {
        List<Message> allChatMessages = new ArrayList<>();
        List<Message> allMessages = messageRepository.findAll();

        for (Message message : allMessages) {
            if (message.getChat().getChatId().equals(chat.getChatId())) {
                allChatMessages.add(message);
            }
        }

        allChatMessages.sort(Comparator.comparing(Message::getCreated_at));

        return allChatMessages;
    }
}
