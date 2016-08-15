package org.light32.projects.m8b;

import java.util.ArrayList;
import java.util.List;

/**
 * the 8 ball
 *
 * @author jwhitt
 */
public class Magic8Ball {

	private static final String[] responseList = {
	"It is certain",
	"It is decidedly so",
	"Without a doubt",
	"Yes, definitely",
	"You may rely on it",
	"As I see it, yes",
	"Most likely",
	"Outlook good",
	"Yes",
	"Signs point to yes",
	"Reply hazy try again",
	"Ask again later",
	"Better not tell you now",
	"Cannot predict now",
	"Concentrate and ask again",
	"Don't count on it",
	"My reply is no",
	"My sources say no",
	"Outlook not so good",
	"Very doubtful" };

	public String ask() {
		long rndIdx = Math.round((Math.random() * 19));
		
		return responseList[Integer.parseInt(Long.toUnsignedString(rndIdx))];
	}
	
}
