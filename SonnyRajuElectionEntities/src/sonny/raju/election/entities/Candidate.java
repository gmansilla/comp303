package sonny.raju.election.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CANDIDATE database table.
 * 
 */
@Entity
@Table(name="CANDIDATE", schema="ELECTION")
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CID")
	private int cid;

	@Column(name="CNAME")
	private String name;

	@Column(name="CVOTES")
	private int votes;

	public Candidate() {
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return this.votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

}