package de.zalando.ep.zalenium.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideosDetails {
	

	public static final String PATH="/home/seluser/videos/windows";
	
	private List<String> videos=new ArrayList<>();
	  
	public VideosDetails(){
		File directory = new File(PATH);
		File[] fileList = directory.listFiles();
        for (File file : fileList){
        	getVideos().add(file.getName());
	    }
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
	
	public int getVideosCount() {
		return videos.size();
	}

}
