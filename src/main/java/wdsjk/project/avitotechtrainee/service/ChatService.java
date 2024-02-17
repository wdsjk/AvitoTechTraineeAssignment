package wdsjk.project.avitotechtrainee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wdsjk.project.avitotechtrainee.entity.Chat;
import wdsjk.project.avitotechtrainee.entity.UserEntity;
import wdsjk.project.avitotechtrainee.repository.ChatRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    private final MessageService messageService;

    @Autowired
    public ChatService(ChatRepository chatRepository, MessageService messageService) {
        this.chatRepository = chatRepository;
        this.messageService = messageService;
    }

    public List<Chat> getALlChats() {
        return chatRepository.findAll();
    }

    public String addChat(Chat chat) {
        chat.setCreated_at(LocalDate.now());

        chatRepository.save(chat);
        return String.valueOf(chat.getChatId());
    }

    public List<Chat> getAllUserChats(UserEntity user) {
        List<Chat> allUserChats = new ArrayList<>();
        List<Chat> allChats = chatRepository.findAll();

        for (Chat chat : allChats) {
            for (UserEntity userEntity : chat.getUsers()) {
                if (userEntity.getUserId().equals(user.getUserId())) {
                    allUserChats.add(chat);
                }
            }
        }

        allUserChats.sort((chat1, chat2) ->
                messageService.getMessageByChatId(chat1.getChatId()).getCreated_at()
                        .compareTo(messageService.getMessageByChatId(chat2.getChatId()).getCreated_at()));

        return allUserChats;
    }
}
