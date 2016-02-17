package entity;

public class Student 
{
	private String name;
	private int[] fagIds = new int[100];
	private int index = 0;

	public Student(String name, int[] fagIds)
	{
		this.name = name;
		for(int i : fagIds)
		{
			fagIds[index] = i;
			index++;
		}
		index = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getFagIds() {
		return fagIds;
	}

	public void setFagIds(int[] fagIds) {
		this.fagIds = fagIds;
	}


	
}
