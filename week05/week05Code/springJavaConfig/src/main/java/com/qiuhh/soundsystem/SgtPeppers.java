package com.qiuhh.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = " Music ";
	private String artist = " The Beatles";
	
	@Override
	public void paly() {
		// TODO Auto-generated method stub
		System.out.println("Playing "+ title +" by "+ artist);
		
	}

}
