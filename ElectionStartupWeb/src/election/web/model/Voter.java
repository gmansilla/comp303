package election.web.model;

import election.web.exceptions.VoterNotRecognizedException;

public class Voter {
	String name;
	String voterId;   // password
	boolean hasVoted;
	
	public Voter(String name, String id ) throws VoterNotRecognizedException {
		setName(name );
		setVoterId( id );
		setVoted( false );
	}
	
	public String getVoterId() {
		return voterId;
	}
	private void setVoterId(String id) throws VoterNotRecognizedException {
		if ( id == null || id.isEmpty() ) {
			throw new VoterNotRecognizedException("Attempt to create voter with no student number");
		}
		voterId = id.trim();
	}
	public String getName() {
		return name;
	}
	private void setName(String name) throws VoterNotRecognizedException {
		if ( name == null || name.isEmpty()) {
			throw new VoterNotRecognizedException("Attempt to create voter with no name");
		}
		this.name = name.trim();
	}

	public boolean isVoted() {
		return hasVoted;
	}

	public void setVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}	

}
