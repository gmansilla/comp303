package election.web.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import election.web.exceptions.ElectionException;

public class Candidates {
	private static Candidates candidates = null;
	Map <String, Integer> candidateNameVotes = null;

	private Candidates() {
		candidateNameVotes = new HashMap<String, Integer>();
		candidateNameVotes.put( "Ju Wen Chen", 0 );
		candidateNameVotes.put( "Grace Semanio", 0 );
		candidateNameVotes.put( "Asif Khan", 0 );
	}

	public static synchronized Candidates getInstance() {
		if ( candidates == null ) {
			candidates = new Candidates();
		}
		return candidates;
	}
	
	public List<String> getCandidateNames() {
		return new ArrayList<String> ( candidateNameVotes.keySet() );
	}
	
	public int getVotes( String name ) throws ElectionException {
		if( candidateNameVotes.get( name ) == null ) {
			throw new ElectionException("Candidate name " + name + " not regonized");
		}
		return candidateNameVotes.get( name );
	}
	
	public void voteFor( String name ) throws ElectionException {
		int votes = getVotes( name ) + 1;
		candidateNameVotes.put( name , votes );		
	}
	
	public void printVoteCount( PrintStream out ) {
		out.print("Vote count so far: ");
		for ( String s : getCandidateNames() ) {
			out.printf("[%-12s%4d] ", s, candidateNameVotes.get(s) );
		}
		out.println();
	}
	
}
