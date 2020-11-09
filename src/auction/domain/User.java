package auction.domain;

public class User {
	
	private int id;
	private String name;
	
	public User(String name) {
		this(0, name);
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object user) {
		if (this == user)
            return true;
        if (user == null)
            return false;
        if (getClass() != user.getClass())
            return false;
        
        User other = (User) user;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
	}

}
