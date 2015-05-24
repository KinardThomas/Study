package group5.project.gostudy;

public class FrontAndBack{
	private String frontCard, backCard;
	public FrontAndBack(String frontInfo, String backInfo)
	{
		frontCard = frontInfo;
		backCard = backInfo;
	}
	public String getFrontCard()
	{
		return frontCard;
	}
	
	public String getBackCard()
	{
		return backCard;
	}
}
