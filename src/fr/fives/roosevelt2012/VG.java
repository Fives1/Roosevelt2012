package fr.fives.roosevelt2012;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class VG {
	static int COLOR_RED = Color.rgb(255, 0, 0);
	static int COLOR_ORANGE = Color.rgb(233, 99, 59);
	static int COLOR_BROWN = Color.rgb(34, 30, 29);
	static int COLOR_BLACK = Color.rgb(0, 0, 0);
	static int COLOR_WHITE = Color.rgb(255, 255, 255);
	static int COLOR_YELLOW = Color.rgb(193, 165, 125);
	static int COLOR_YELLOW_WHITE = Color.rgb(236, 234, 224);
	static int COLOR_GREY = Color.rgb(170, 170, 170);
	static int COLOR_GREEN_BLUE = Color.rgb(99, 170, 156);
	static String COLLECTIFNAMESFILE_ORIGINALORDER = "noms_dans_le_collectif_orignalorder.html";
	static String COLLECTIFNAMESFILE_FIRSTNAMESORDER = "noms_dans_le_collectif_firstnameorder.html";
	static String COLLECTIFNAMESFILE_LASTNAMESORDER = "noms_dans_le_collectif_lastnameorder.html";
	static ArrayList<String> REFORMS_RUBRICS = null;
	static ArrayList<Reform> REFORMS_TITLE = null;
	static enum language {FRENCH, ENGLISH, ITALIAN, SPANISH, GERMANY};
	
	enum TYPE_STORAGE {ASSETS, INTERNAL}
	static String searchText = null;
	
	static language languageChoiced = null;

	static List all_schemas = null;
	static String insternetSiteUrl = null;
	static String schemas = null;
//	static String jeSigneEtApresUrl = null;
	static String jeSigneUrl = null;
	static String etApresUrl = null;
//	static String jeSigneEtApres = null;
	static String jeSigne = null;
	static String etApres = null;
	static String leCollectif = null;
	static String laVideoUrl = null;
	static String laVideo = null;
	static String lesGroupesLocauxUrl = null;
	static String lesGroupesLocaux = null;
	static String actualitesUrl = null;
	static String actualites = null;
	static String title = null;
	static String countOfSignatures = null;
	static String stephaneHessel_text = null;
	static String nousAvonsDecideDAgir_Titre = null;
	static String nousAvonsDecideDAgir_Corps = null;
	static String nousAvonsDecideDAgir_Url = null;
	static String nousSouhaitonsContribuer = null;
	static String direLExtremeGravite = null;
	static String direLExtremeGravite_Url = null;
	static String troisChantier = null;
	static String quinzeReformes = null;
	static String mesMentions_information = null;
	static String mesMentions_textButton = null;
	static String mesMentions_titre = null;
	static String mesMentions_corps = null;
	static int textSizeOfTitleInButton = 20;
	static int textSizeOfBodyInButton = 14;

}
