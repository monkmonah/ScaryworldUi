package com.scaryworld.ui.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.scaryworld.ui.model.Message;
import com.scaryworld.ui.model.OutputMessage;

@Controller
public class ChatController {
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
		if("god".equalsIgnoreCase(message.getFrom())) {
			message.setText(message.getText().toUpperCase());
		}
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("FIELD_SIZE_X", "");
        return "home";
    }
}
