package election.web.model;

import java.util.HashMap;
import java.util.Map;

import election.web.exceptions.VoterNotRecognizedException;

public class ElectoralRoll {
	private static ElectoralRoll electoralRoll = null;
	private Map<String, Voter> voters = null;

	private ElectoralRoll() throws VoterNotRecognizedException {
		voters = new HashMap<String, Voter>();
		// passwords are based on the NATO phonetic AlphaBet
		voters.put("A", new Voter("A", "Alpha"));
		voters.put("B", new Voter("B", "Bravo"));
		voters.put("C", new Voter("C", "Charlie"));
		voters.put("D", new Voter("D", "Delta"));
		voters.put("E", new Voter("E", "Echo"));
		voters.put("F", new Voter("F", "Foxtrot"));
		voters.put("G", new Voter("G", "Golf"));
		voters.put("H", new Voter("H", "Hotel"));
		voters.put("I", new Voter("I", "India"));
		voters.put("J", new Voter("J", "Juliet"));
		voters.put("K", new Voter("K", "Kilo"));
		voters.put("L", new Voter("L", "Lima"));
		voters.put("M", new Voter("M", "Mike"));
		voters.put("N", new Voter("N", "November"));
		voters.put("O", new Voter("O", "Oscar"));
		voters.put("P", new Voter("P", "Papa"));
		voters.put("Q", new Voter("Q", "Quebec"));
		voters.put("R", new Voter("R", "Romeo"));
		voters.put("S", new Voter("S", "Sierra"));
		voters.put("T", new Voter("T", "Tango"));
		voters.put("U", new Voter("U", "Uniform"));
		voters.put("V", new Voter("V", "Victor"));
		voters.put("W", new Voter("W", "Whiskey"));
		voters.put("X", new Voter("X", "X-ray"));
		voters.put("Y", new Voter("Y", "Yankee"));
		voters.put("Z", new Voter("Z", "Zulu"));
	}

	public static synchronized ElectoralRoll getInstance() {
		try {
			if (electoralRoll == null) {
				electoralRoll = new ElectoralRoll();
			}
		} catch (VoterNotRecognizedException vnre) {
			// exception should never happen
		}
		return electoralRoll;
	}
	
	// returns null if no voter has this name/key
	public Voter getVoter( String name ) {
		return voters.get( name );
	}
	
	public boolean authenticate( String name, String voterId ) {
		Voter voter = voters.get( name );
		if ( voter == null ) {
			return false;
		}
		if ( voter.getVoterId().equals(voterId)) {
			return true;
		}
		return false;
	}
	
}
