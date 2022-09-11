package com.alisk.chatroom.repository;

import com.alisk.chatroom.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    Integer countByRoomId(Integer roomId);

    Integer countBySenderId(Integer userId);

}
