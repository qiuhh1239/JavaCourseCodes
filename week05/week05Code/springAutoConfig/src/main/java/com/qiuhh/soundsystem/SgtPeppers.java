package com.qiuhh.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = " Cloud Band";
	private String artist = " The Beatles";

	public void paly() {
		// TODO Auto-generated method stub
		System.out.println("Playing "+ title +" by "+ artist);
		
	}

}
