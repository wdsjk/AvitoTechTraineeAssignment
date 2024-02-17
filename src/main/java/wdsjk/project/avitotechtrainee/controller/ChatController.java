package wdsjk.project.avitotechtrainee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wdsjk.project.avitotechtrainee.entity.Chat;
import wdsjk.project.avitotechtrainee.entity.UserEntity;
import wdsjk.project.avitotechtrainee.service.ChatService;

import java.util.List;

@RestController
@RequestMapping(path = "api/chats")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats() {
        return ResponseEntity.ok(chatService.getALlChats());
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<String> addChat(@RequestBody Chat chat) {
        return ResponseEntity.ok(chatService.addChat(chat));
    }

    @PostMapping("/get")
    public @ResponseBody ResponseEntity<List<Chat>> getAllUsersChats(@RequestBody UserEntity user) {
        return ResponseEntity.ok(chatService.getAllUserChats(user));
    }
}
