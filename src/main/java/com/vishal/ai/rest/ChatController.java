package com.vishal.ai.rest;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


  private final ChatClient chatClient;

  @Autowired
  public ChatController(ChatClient.Builder chatClient) {
    this.chatClient = chatClient.build();
  }


  @GetMapping("/chat")
  public String getResponse(@RequestParam(value = "prompt") String prompt) {
    return chatClient.prompt(Prompt.builder().content(prompt).build())
        .call().content();
  }

}
