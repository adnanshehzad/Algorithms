package lab11_undirected;


public class Vertex implements Cloneable{

	private String data;


	public Vertex(String data){
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String toString() {
		return data;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	/**
	 * Returns a shallow copy of this Vertex. For some purposes,
	 * a deep copy would be preferable (but this graph package does not
	 * require support for this since data in each vertex is usually a String).
	 */
	public Vertex clone() {
		try {
			Vertex copy = (Vertex)super.clone();
			return copy;
		} catch(CloneNotSupportedException e) {
			throw new IllegalStateException("Unable to clone this vertex: " + data.toString());
		}
	}
}
