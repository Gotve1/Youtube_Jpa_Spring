package com.example.youtube.service;

import com.example.youtube.model.Channel;
import com.example.youtube.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(UUID id) {
        return channelRepository.findById(id).orElseThrow(() -> new RuntimeException("Channel not found"));
    }

    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public Channel updateChannel(UUID id, Channel channelDetails) {
        Channel channel = getChannelById(id);
        channel.setName(channelDetails.getName());
        channel.setPhoto(channelDetails.getPhoto());
        channel.setDescription(channelDetails.getDescription());
        channel.setStatus(channelDetails.getStatus());
        channel.setBanner(channelDetails.getBanner());
        return channelRepository.save(channel);
    }

    public void deleteChannel(UUID id) {
        channelRepository.deleteById(id);
    }
}