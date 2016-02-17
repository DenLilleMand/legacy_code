
public class Division {
	VicePresident[] vps;
	int index;
	
	public Division()
	{
		vps = new VicePresident[100];
		index = 0;
	}
	
	public VicePresident[] getVicePresidents()
	{
		return vps;
	}
	
	public void addVicePresident(VicePresident vp)
	{
		vps[index] = vp;
		index++;
	}
}
