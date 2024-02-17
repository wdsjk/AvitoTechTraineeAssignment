package wdsjk.project.avitotechtrainee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wdsjk.project.avitotechtrainee.entity.Chat;
import wdsjk.project.avitotechtrainee.entity.Message;
import wdsjk.project.avitotechtrainee.service.MessageService;

import java.util.List;

@RestController
@RequestMapping(path = "api/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<String> addMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.save(message));
    }

    @PostMapping("/get")
    public @ResponseBody ResponseEntity<List<Message>> getAllChatMessages(@RequestBody Chat chat) {
        return ResponseEntity.ok(messageService.getAllChatMessages(chat));
    }
}
