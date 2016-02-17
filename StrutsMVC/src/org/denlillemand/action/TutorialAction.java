package org.denlillemand.action;

public class TutorialAction 
{
	private String bestTutorialSite;
	private String language;

	//url - http://mywebapp/getTutorial
	/**
	 * Vores default execute metode, som SKAL have den her signature.
	 * @return
	 */
		public String execute()
		{
			TutorialFinderService service = new TutorialFinderService();
			setBestTutorialSite(service.getBestTutorialSite(getLanguage()));
			
			return "success";
		}
		
		
		public String getLanguage() {
			return language;
		}


		public void setLanguage(String language) {
			this.language = language;
		}

		public String getBestTutorialSite() {
			return bestTutorialSite;
		}

		public void setBestTutorialSite(String bestTutorialSite) {
			this.bestTutorialSite = bestTutorialSite;
		}

	
}
