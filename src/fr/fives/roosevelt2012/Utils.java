package fr.fives.roosevelt2012;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.widget.Toast;
import fr.fives.roosevelt2012.VG.language;

public class Utils {

	/**
	 * Exec Internet Browser
	 * @param context
	 * @param url
	 */
    protected static void execInternetBrowser(Context context, String url) {
    	if (context!=null && url!=null && !"".equals(url)) {
	    	if (isConnectedToInternet(context)) {
				context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
	    	} else {
	    		Toast.makeText(context, "Nécessite une connexion internet", Toast.LENGTH_SHORT).show();
	    	}
    	}
	}

    /**
     * Test connexion to internet
     * @param context
     * @return
     */
    protected static boolean isConnectedToInternet(Context context) {
		boolean res = false;
		if (context!=null) {
			if (context!=null) {
				ConnectivityManager connectivityManager = (ConnectivityManager) context
						.getSystemService(context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
				if (networkInfo != null) {
					State networkState = networkInfo.getState();
					if (networkState.compareTo(State.CONNECTED) == 0) {
						res = true;
					} else {
						res = false;
					}
				}
			}
		}
		return res;
	}

    /**
     * Valorize the table of schemas (file name, url, legend)
     * @param language
     */
	public static void valorizeSchemasNamesAndUrlsAndLegends(VG.language language) {
		if (language!=null) {
	        VG.all_schemas = new LinkedList<OneFile>();
			if (language==VG.language.ENGLISH) {
		        VG.all_schemas.add(new OneFile("detteusadepuis1925.jpg", "http://www.roosevelt2012.fr/img/detteusadepuis1925.jpg", "Total debt of the United States since 1925"));
		        VG.all_schemas.add(new OneFile("dixansdebaissedimpots.jpg", "http://www.roosevelt2012.fr/img/propositions/dixansdebaissedimpots.jpg", "Ten years of tax cuts"));
		        VG.all_schemas.add(new OneFile("evolutioncoutssalariauxenchine.jpg", "http://www.roosevelt2012.fr/img/propositions/evolutioncoutssalariauxenchine.jpg", "Evolution of wage costs in China"));
		        VG.all_schemas.add(new OneFile("uneeconomieplusecologique.jpg", "http://www.roosevelt2012.fr/img/propositions/uneeconomieplusecologique.jpg", "A greener economy"));
		        VG.all_schemas.add(new OneFile("dureetravailusa.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailusa.jpg", "Hours of work in the United States"));
		        VG.all_schemas.add(new OneFile("dureetravailallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailallemagne.jpg", "Working hours in Germany"));
		        VG.all_schemas.add(new OneFile("productiviteenfrance.jpg", "http://www.roosevelt2012.fr/img/propositions/productiviteenfrance.jpg", "Productivity in France since 1820"));
		        VG.all_schemas.add(new OneFile("emploiprodmanufusa.jpg", "http://www.roosevelt2012.fr/img/propositions/emploiprodmanufusa.jpg", "Industrial production and industrial employment in the U.S."));
		        VG.all_schemas.add(new OneFile("lemonderapportplan.jpg", "http://www.roosevelt2012.fr/img/propositions/lemonderapportplan.jpg", "Le Monde - One Plan report recommends a reduction of more than 20% of working time in twenty years"));
		        VG.all_schemas.add(new OneFile("bataille32hallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/bataille32hallemagne.jpg", "The battle of 32 hours in Germany"));
		        VG.all_schemas.add(new OneFile("europeunanimite27.jpg", "http://www.roosevelt2012.fr/img/propositions/europeunanimite27.jpg", "Europe - Therefore the 27 to agree, unanimously, that you change the content of a policy."));
		        VG.all_schemas.add(new OneFile("europedemocratiqueparlement.jpg", "http://www.roosevelt2012.fr/img/propositions/europedemocratiqueparlement.jpg", "This is a political discussion (left / right / ...) which is decided in Parliament and not a struggle between nations."));
		        VG.all_schemas.add(new OneFile("phototraitesocial.jpg", "http://www.roosevelt2012.fr/img/propositions/phototraitesocial.jpg", "To support our initiative and ask the Convention Giscard wrote that the European Constitution to reflect the Commission President, Romano Prodi, had received a delegation of the first signatories."));
			} else if (language==VG.language.ITALIAN) {
		        VG.all_schemas.add(new OneFile("detteusadepuis1925.jpg", "http://www.roosevelt2012.fr/img/detteusadepuis1925.jpg", "L'indebitamento totale degli Stati Uniti dal 1925"));
		        VG.all_schemas.add(new OneFile("dixansdebaissedimpots.jpg", "http://www.roosevelt2012.fr/img/propositions/dixansdebaissedimpots.jpg", "Dieci anni di tagli alle tasse"));
		        VG.all_schemas.add(new OneFile("evolutioncoutssalariauxenchine.jpg", "http://www.roosevelt2012.fr/img/propositions/evolutioncoutssalariauxenchine.jpg", "Evoluzione dei costi salariali in Cina"));
		        VG.all_schemas.add(new OneFile("uneeconomieplusecologique.jpg", "http://www.roosevelt2012.fr/img/propositions/uneeconomieplusecologique.jpg", "Un'economia più verde"));
		        VG.all_schemas.add(new OneFile("dureetravailusa.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailusa.jpg", "Ore di lavoro negli Stati Uniti"));
		        VG.all_schemas.add(new OneFile("dureetravailallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailallemagne.jpg", "Ore di lavoro in Germania"));
		        VG.all_schemas.add(new OneFile("productiviteenfrance.jpg", "http://www.roosevelt2012.fr/img/propositions/productiviteenfrance.jpg", "Productividad in Francia dal 1820"));
		        VG.all_schemas.add(new OneFile("emploiprodmanufusa.jpg", "http://www.roosevelt2012.fr/img/propositions/emploiprodmanufusa.jpg", "La produzione industriale e l'occupazione industriale negli Stati Uniti"));
		        VG.all_schemas.add(new OneFile("lemonderapportplan.jpg", "http://www.roosevelt2012.fr/img/propositions/lemonderapportplan.jpg", "Le Monde - Un rapporto Piano raccomanda una riduzione di oltre il 20% del tempo di lavoro in venti anni"));
		        VG.all_schemas.add(new OneFile("bataille32hallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/bataille32hallemagne.jpg", "La battaglia di 32 ore in Germania"));
		        VG.all_schemas.add(new OneFile("europeunanimite27.jpg", "http://www.roosevelt2012.fr/img/propositions/europeunanimite27.jpg", "Europa - deve quindi essere déaccord 27, all'unanimità, di modificare il contenuto di una politica."));
		        VG.all_schemas.add(new OneFile("europedemocratiqueparlement.jpg", "http://www.roosevelt2012.fr/img/propositions/europedemocratiqueparlement.jpg", "Si tratta di un dibattito politico (sinistra / destra / ...) che si decide in Parlamento e non una lotta tra le nazioni."));
		        VG.all_schemas.add(new OneFile("phototraitesocial.jpg", "http://www.roosevelt2012.fr/img/propositions/phototraitesocial.jpg", "Per sostenere la nostra iniziativa e chiedere la Convenzione Giscard ha scritto che la Costituzione europea in modo da riflettere il Presidente della Commissione, Romano Prodi, ha ricevuto una delegazione dei primi firmatari."));
			} else if (language==VG.language.SPANISH) {
		        VG.all_schemas.add(new OneFile("detteusadepuis1925.jpg", "http://www.roosevelt2012.fr/img/detteusadepuis1925.jpg", "La deuda total de los Estados Unidos desde 1925"));
		        VG.all_schemas.add(new OneFile("dixansdebaissedimpots.jpg", "http://www.roosevelt2012.fr/img/propositions/dixansdebaissedimpots.jpg", "Diez años de recortes de impuestos"));
		        VG.all_schemas.add(new OneFile("evolutioncoutssalariauxenchine.jpg", "http://www.roosevelt2012.fr/img/propositions/evolutioncoutssalariauxenchine.jpg", "La evolución de los costes salariales en China"));
		        VG.all_schemas.add(new OneFile("uneeconomieplusecologique.jpg", "http://www.roosevelt2012.fr/img/propositions/uneeconomieplusecologique.jpg", "Una economía más verde"));
		        VG.all_schemas.add(new OneFile("dureetravailusa.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailusa.jpg", "Horas de trabajo en los Estados Unidos"));
		        VG.all_schemas.add(new OneFile("dureetravailallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailallemagne.jpg", "Las horas de trabajo en Alemania"));
		        VG.all_schemas.add(new OneFile("productiviteenfrance.jpg", "http://www.roosevelt2012.fr/img/propositions/productiviteenfrance.jpg", "La productividad en Francia desde 1820"));
		        VG.all_schemas.add(new OneFile("emploiprodmanufusa.jpg", "http://www.roosevelt2012.fr/img/propositions/emploiprodmanufusa.jpg", "La producción industrial y el empleo industrial en los EE.UU."));
		        VG.all_schemas.add(new OneFile("lemonderapportplan.jpg", "http://www.roosevelt2012.fr/img/propositions/lemonderapportplan.jpg", "Le Monde - Un informe de Plan recomienda una reducción de más del 20% del tiempo de trabajo en veinte años"));
		        VG.all_schemas.add(new OneFile("bataille32hallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/bataille32hallemagne.jpg", "La batalla de 32 horas en Alemania"));
		        VG.all_schemas.add(new OneFile("europeunanimite27.jpg", "http://www.roosevelt2012.fr/img/propositions/europeunanimite27.jpg", "Europa - Por lo tanto el 27 de acordar, por unanimidad, que cambia el contenido de una política."));
		        VG.all_schemas.add(new OneFile("europedemocratiqueparlement.jpg", "http://www.roosevelt2012.fr/img/propositions/europedemocratiqueparlement.jpg", "Esta es una debate política (izquierda / derecha / ...) que se decide en el Parlamento y no una lucha entre naciones."));
		        VG.all_schemas.add(new OneFile("phototraitesocial.jpg", "http://www.roosevelt2012.fr/img/propositions/phototraitesocial.jpg", "Para apoyar nuestra iniciativa y pedir a la convención de Giscard escribió que la Constitución Europea para reflejar el Presidente de la Comisión, Romano Prodi, ha recibido a una delegación de los primeros signatarios."));
			} else if (language==VG.language.GERMANY) {
		        VG.all_schemas.add(new OneFile("detteusadepuis1925.jpg", "http://www.roosevelt2012.fr/img/detteusadepuis1925.jpg", "Gesamtverschuldung der Vereinigten Staaten seit 1925"));
		        VG.all_schemas.add(new OneFile("dixansdebaissedimpots.jpg", "http://www.roosevelt2012.fr/img/propositions/dixansdebaissedimpots.jpg", "Zehn Jahre Steuersenkungen"));
		        VG.all_schemas.add(new OneFile("evolutioncoutssalariauxenchine.jpg", "http://www.roosevelt2012.fr/img/propositions/evolutioncoutssalariauxenchine.jpg", "Evolution der Lohnkosten in China"));
		        VG.all_schemas.add(new OneFile("uneeconomieplusecologique.jpg", "http://www.roosevelt2012.fr/img/propositions/uneeconomieplusecologique.jpg", "Eine grünere Wirtschaft"));
		        VG.all_schemas.add(new OneFile("dureetravailusa.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailusa.jpg", "Stunden Arbeit in den Vereinigten Staaten"));
		        VG.all_schemas.add(new OneFile("dureetravailallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailallemagne.jpg", "Arbeitszeiten in Deutschland"));
		        VG.all_schemas.add(new OneFile("productiviteenfrance.jpg", "http://www.roosevelt2012.fr/img/propositions/productiviteenfrance.jpg", "Produktivität in Frankreich seit 1820"));
		        VG.all_schemas.add(new OneFile("emploiprodmanufusa.jpg", "http://www.roosevelt2012.fr/img/propositions/emploiprodmanufusa.jpg", "Industrielle Produktion und Beschäftigung in der Industrie in den USA"));
		        VG.all_schemas.add(new OneFile("lemonderapportplan.jpg", "http://www.roosevelt2012.fr/img/propositions/lemonderapportplan.jpg", "Le Monde - One-Plan Bericht empfiehlt eine Reduzierung von mehr als 20% der Arbeitszeit in zwanzig Jahren"));
		        VG.all_schemas.add(new OneFile("bataille32hallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/bataille32hallemagne.jpg", "Die Schlacht von 32 Stunden in Deutschland"));
		        VG.all_schemas.add(new OneFile("europeunanimite27.jpg", "http://www.roosevelt2012.fr/img/propositions/europeunanimite27.jpg", "Europa - also die 27 zustimmen, einstimmig, dass Sie den Inhalt einer Politik zu ändern."));
		        VG.all_schemas.add(new OneFile("europedemocratiqueparlement.jpg", "http://www.roosevelt2012.fr/img/propositions/europedemocratiqueparlement.jpg", "Dies ist eine politische Diskussion (links / rechts / ...), die im Parlament beschlossen wird und nicht ein Kampf zwischen den Nationen."));
		        VG.all_schemas.add(new OneFile("phototraitesocial.jpg", "http://www.roosevelt2012.fr/img/propositions/phototraitesocial.jpg", "Um unsere Initiative zu unterstützen und bitten Sie den Konvents, Giscard schrieb, dass die Europäische Verfassung zu reflektieren derPräsident der Kommission, Romano Prodi, hatte eine Delegation der ersten Unterzeichnern erhalten."));
			} else {
		        VG.all_schemas.add(new OneFile("detteusadepuis1925.jpg", "http://www.roosevelt2012.fr/img/detteusadepuis1925.jpg", "Dette totale des Etats-Unis depuis 1925"));
		        VG.all_schemas.add(new OneFile("dixansdebaissedimpots.jpg", "http://www.roosevelt2012.fr/img/propositions/dixansdebaissedimpots.jpg", "Dix ans de baisse d'impôts"));
		        VG.all_schemas.add(new OneFile("evolutioncoutssalariauxenchine.jpg", "http://www.roosevelt2012.fr/img/propositions/evolutioncoutssalariauxenchine.jpg", "Evolution des coûts salariaux en Chine"));
		        VG.all_schemas.add(new OneFile("uneeconomieplusecologique.jpg", "http://www.roosevelt2012.fr/img/propositions/uneeconomieplusecologique.jpg", "Une économie plus écologique"));
		        VG.all_schemas.add(new OneFile("dureetravailusa.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailusa.jpg", "Durée du travail aux Etats-Unis"));
		        VG.all_schemas.add(new OneFile("dureetravailallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/dureetravailallemagne.jpg", "Durée du travail en Allemagne"));
		        VG.all_schemas.add(new OneFile("productiviteenfrance.jpg", "http://www.roosevelt2012.fr/img/propositions/productiviteenfrance.jpg", "Productivité en France depuis 1820"));
		        VG.all_schemas.add(new OneFile("emploiprodmanufusa.jpg", "http://www.roosevelt2012.fr/img/propositions/emploiprodmanufusa.jpg", "Production industrielle et emploi industrielle aux USA"));
		        VG.all_schemas.add(new OneFile("lemonderapportplan.jpg", "http://www.roosevelt2012.fr/img/propositions/lemonderapportplan.jpg", "Le Monde - Un rapport du Plan préconise une réduction de plus de 20% du temps de travail en vingt ans"));
		        VG.all_schemas.add(new OneFile("bataille32hallemagne.jpg", "http://www.roosevelt2012.fr/img/propositions/bataille32hallemagne.jpg", "La bataille des 32 heures en Allemagne"));
		        VG.all_schemas.add(new OneFile("europeunanimite27.jpg", "http://www.roosevelt2012.fr/img/propositions/europeunanimite27.jpg", "Europe -  Il faut donc que les 27 soient déaccord, à l'unanimité, pour que l'on change le contenu d'une politique."));
		        VG.all_schemas.add(new OneFile("europedemocratiqueparlement.jpg", "http://www.roosevelt2012.fr/img/propositions/europedemocratiqueparlement.jpg", "C'est bien un débat politique (droite/ gauche/ ...) qui est tranché dans un Parlement et non un combat entre nations."));
		        VG.all_schemas.add(new OneFile("phototraitesocial.jpg", "http://www.roosevelt2012.fr/img/propositions/phototraitesocial.jpg", "Pour soutenir notre initiative et demander à la Convention Giscard qui rédigeait la Constitution européenne d'en tenir compte, le Président de la Commission, Romano Prodi, avait reçu une délégation des premiers signataires."));
			}
		}
	}
	
	/**
	 * Extract Input Stream From Asset Directory
	 * @param context
	 * @param idFile
	 * @return
	 */
	public static InputStream extractInputStreamFromAsset(Context context,
			String idFile) {
		InputStream is = null;
		if (context!=null && idFile!=null && !"".equals(idFile)) {
			Resources resources = context.getResources();
			AssetManager assMan = resources.getAssets();
			try {
				is = assMan.open(idFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return is;
	}

	/**
	 * Create a simple string with a table of strings
	 * @param tab
	 * @return
	 */
	public static String createStringWithTabOfStrings(ArrayList<String> tab) {
		String res = "";
		if (tab!=null) {
			res = "";
			Iterator<String> iterator = tab.iterator();
			String text = null;
			while (iterator.hasNext()) {
				text = (String) iterator.next();
				res += text;
				if (iterator.hasNext()) {
					res += "<br/>";
				}
			}
		}
		return res;
	}

	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorize15Reforms(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("<b>15 reforms</b>");
			} else if (language==VG.language.ITALIAN) {
				text.add("<b>15 riforme</b>");
			} else if (language==VG.language.SPANISH) {
				text.add("<b>15 reformas</b>");
			} else if (language==VG.language.GERMANY) {
				text.add("<b>15 Reformen</b>");
			} else {
				text.add("<b>15 réformes</b>");
			}
			VG.quinzeReformes = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeTroisChantiers(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("");
				text.add("<b>Three priority projects</b>");
			} else if (language==VG.language.ITALIAN) {
				text.add("");
				text.add("<b>3 cantieri prioritari</b>");
			} else if (language==VG.language.SPANISH) {
				text.add("");
				text.add("<b>Tres sitios prioritarias</b>");
			} else if (language==VG.language.GERMANY) {
				text.add("");
				text.add("<b>Drei Schwerpunktbereiche</b>");
			} else {
				text.add("");
				text.add("<b>3 chantiers prioritaires</b>");
			}
			VG.troisChantier = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeDireLEctremeGravite(Context context, language language) {
		if (context!=null && language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
		        text.add("<h1>Here's just how serious the situation is:</h1>");
		        text.add("There is increasing despair in our country, France. There are already 500,000 unemployed people registered with the unemployment office, hundreds of thousands of the unemployed who no longer qualify for benefits, and millions of people living in poor and precarious conditions. Hundreds of thousands of families have great difficulty paying their rent or utility bills, and there is every indication that a new recession is likely in the near future.");
		        text.add("<b>The total amount of U.S. debt has attained 358% of GDP (Gross Domestic Product)</b>. In the first 3 months of 2011, while U.S. public debt increased by 380 billion dollars, the GDP increased by a mere 50 billion. More debt for less growth! The world's biggest economy is like a car that needs a pint of oil every 500 feet. At any moment, a piston rod might succumb and the engine explode. Colossal budgetary cuts planned for 2013 may throw the USA into a recession of historic magnitude.");
		        text.add("<b>In China, the real estate bubble</b> is double the maximum amount reached by the bubble in the United-States before the subprime loan crisis. In 2009, in order to avoid recession, the government ordered banks to grant all the credit requests they received.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Click here to read more (internet access)");
		        } else {
		        	text.add("To read more, you must have an internet connection.");
		        }
			} else if (language==VG.language.ITALIAN) {
		        text.add("<h1>Dire l'estrema gravità della situazione</h1>");
		        text.add("Ci sono già più di 5 milioni d'iscritti alla disoccupazione, dei milioni di precari e non c'è dubbio, purtroppo, che stiamo per ricadere in recessione.");
		        text.add("La crisi delle « subprimes » è nata negli Stati Uniti ed una nuova crisi si sta preparando : <b>il debito totale degli Stati Uniti raggiunge il 358% del PIL</b>. Nel 2011, mentre il debito pubblico aumentava di 1.300 miliardi, il PIL è aumentato di solo 260 miliardi. Il PIL aumenta 5 volte meno che il debito ! Sempre più debito e sempre meno crescita ... La prima economia mondiale è come un'auto che ha bisogno di un litro d'olio ogni 300 metri. Ad ogni istante, una biella può rompersi e fare esplodere il motore. Dei tagli colossali nel budget sono previsti a partire dal 2013 che rischiano di fare affondare gli Stati Uniti in una recessione storica.");
		        text.add("In Cina, la « bolla » immobiliare è al più del doppio del massimo raggiunto dalla « bolla » negli U.S.A. prima della crisi delle « subprimes ». Nel 2009, per evitare la recessione, il governo ha ingiunto alle banche di accettare tutte le domande di credito che ricevevano ...");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Clicca qui per vedere il manifesto completo pdf (accesso a Internet)");
		        } else {
		        	text.add("Per saperne di più, è necessario disporre di una connessione a Internet.");
		        }
			} else if (language==VG.language.SPANISH) {
		        text.add("<h1>Proclamar la extrema gravedad de la situación</h1>");
		        text.add("La inquietud se ha instalado en España y Europa. Sólo en España ya hay más de 5.000.000 de parados inscritos en las Oficinas de Empleo, centenares de miles de personas al final de su prestación por desempleo y millones de pobres y precarios. Centenares de miles de familias tienen dificultades para pagar sus alquileres y todo indica que vamos pronto a hundirnos en una nueva recesión.");
		        text.add("<b>La deuda total de los Estados Unidos alcanza el 358% del PIB</b>. En 2011, mientras que la deuda pública aumentaba en 1,07 billones de dólares, el PIB por habitante aumentó sólo en un 1 % ¡Cada vez más deuda para menos crecimiento! La primera economía mundial es como un coche, que necesita un litro de gasolina cada 300 metros. En cualquier momento, se puede romper una biela y el motor explotará. Se prevén recortes presupuestarios colosales a partir de 2013 que amenazan con hundir a los Estados Unidos en una recesión histórica.");
		        text.add("<b>En China la burbuja inmobiliaria ha alcanzado más del doble del máximo alcanzado por la burbuja en los Estados Unidos antes de la crisis de las subprimes. En 2009, para evitar la recesión, el gobierno ordenó a los bancos aceptar todas las solicitudes de crédito que les llegaban.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Haga clic aquí para leer más (acceso a Internet)");
		        } else {
		        	text.add("Para leer más, debe tener una conexión a internet.");
		        }
			} else if (language==VG.language.GERMANY) {
		        text.add("<h1>Dire l'extrême gravité de la situation</h1>");
		        text.add("Il y a déjà plus de 5 millions d'inscrits à Pôle Emploi, des millions de précaires et nul doute hélas que nous allons bientôt replonger en récession.");
		        text.add("La crise des subprimes est née aux Etats-Unis et une nouvelle crise est en préparation : <b>la dette totale des Etats-Unis atteint 358 % du PIB</b>. En 2011, alors que la dette publique augmentait de 1.300 milliards, le PIB a augmenté de 260 milliards seulement. Le PIB augmente 5 fois moins vite que la dette ! De plus en plus de dette pour de moins en moins de croissance... La première économie mondiale est comme une voiture, qui a besoin d’un litre d’huile tous les 300 mètres. A tout moment, elle peut casser une bielle et le moteur va exploser. Des coupes budgétaires colossales sont prévues à partir de 2013 qui risquent de faire plonger les USA dans une récession historique.");
		        text.add("En Chine, la bulle immobilière a atteint plus du double du maximum atteint par la bulle aux Etats-Unis avant la crise des subprimes. En 2009, pour éviter la récession, le gouvernement a ordonné aux banques d’accepter toutes les demandes de crédit qui leur parvenaient...");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Cliquer ici pour lire la suite (accès internet)");
		        } else {
		        	text.add("Pour lire la suite, vous devez avoir une connexion internet.");
		        }
			} else {
		        text.add("<h1>Dire l'extrême gravité de la situation</h1>");
		        text.add("Il y a déjà plus de 5 millions d'inscrits à Pôle Emploi, des millions de précaires et nul doute hélas que nous allons bientôt replonger en récession.");
		        text.add("La crise des subprimes est née aux Etats-Unis et une nouvelle crise est en préparation : <b>la dette totale des Etats-Unis atteint 358 % du PIB</b>. En 2011, alors que la dette publique augmentait de 1.300 milliards, le PIB a augmenté de 260 milliards seulement. Le PIB augmente 5 fois moins vite que la dette ! De plus en plus de dette pour de moins en moins de croissance... La première économie mondiale est comme une voiture, qui a besoin d’un litre d’huile tous les 300 mètres. A tout moment, elle peut casser une bielle et le moteur va exploser. Des coupes budgétaires colossales sont prévues à partir de 2013 qui risquent de faire plonger les USA dans une récession historique.");
		        text.add("En Chine, la bulle immobilière a atteint plus du double du maximum atteint par la bulle aux Etats-Unis avant la crise des subprimes. En 2009, pour éviter la récession, le gouvernement a ordonné aux banques d’accepter toutes les demandes de crédit qui leur parvenaient...");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Cliquer ici pour lire la suite (accès internet)");
		        } else {
		        	text.add("Pour lire la suite, vous devez avoir une connexion internet.");
		        }
			}
			VG.direLExtremeGravite = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeNousSouhaitonsContribuer(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("");
			    text.add("<b>We wish to contribute to the formation of a powerful citizens' movement, an uprising of consciousness that can lead to a political height requirements</b>");
			    text.add("");
			    text.add("<i>Stéphane Hessel, Edgar Morin</i>");
			    text.add("<i>Le chemin de l'espérance</i>");
			    text.add("<i>The path of hope</i>");
			} else if (language==VG.language.ITALIAN) {
				text.add("");
				text.add("<b>Nous souhaitons contribuer à la formation d'un puissant mouvement citoyen, d'une insurrection des consciences qui puisse engendrer une politique à la hauteur des exigences</b>");
				text.add("<i>Vogliamo contribuire alla formazione di un movimento di cittadini potenti, una rivolta della coscienza che può portare ad una requisiti di altezza politici</i>");
				text.add("");
				text.add("<i>Stéphane Hessel, Edgar Morin</i>");
		      	text.add("<i>Le chemin de l'espérance</i>");
		      	text.add("<i>Il cammino della speranza</i>");
			} else if (language==VG.language.SPANISH) {
				text.add("");
				text.add("<b>Nous souhaitons contribuer à la formation d'un puissant mouvement citoyen, d'une insurrection des consciences qui puisse engendrer une politique à la hauteur des exigences</b>");
				text.add("<i>Queremos contribuir a la formación de un movimiento de ciudadanos poderosos, un levantamiento de la conciencia que puede llevar a una serie de requisitos de altura requisitos</i>");
				text.add("<i>Stéphane Hessel, Edgar Morin</i>");
		      	text.add("<i>Le chemin de l'espérance</i>");
		      	text.add("<i>El camino de la esperanza</i>");
			} else if (language==VG.language.GERMANY) {
				text.add("");
			    text.add("<b>Nous souhaitons contribuer à la formation d'un puissant mouvement citoyen, d'une insurrection des consciences qui puisse engendrer une politique à la hauteur des exigences</b>");
			    text.add("<i>Wir wollen auf die Bildung einer starken Bürgerbewegung, ein Aufstand des Bewusstseins, die eine politische Höhe Anforderungen führen dazu beitragen können</i>");
			    text.add("");
			    text.add("<i>Stéphane Hessel, Edgar Morin</i>");
			    text.add("<i>Le chemin de l'espérance</i>");
			    text.add("<i>Der Weg der Hoffnung</i>");
			} else {
				text.add("");
			    text.add("<b>Nous souhaitons contribuer à la formation d'un puissant mouvement citoyen, d'une insurrection des consciences qui puisse engendrer une politique à la hauteur des exigences</b>");
			    text.add("");
			    text.add("<i>Stéphane Hessel, Edgar Morin</i>");
			    text.add("<i>Le chemin de l'espérance</i>");
			}
			VG.nousSouhaitonsContribuer = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeTitle(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("English version not finished. Waiting ...");
			} else if (language==VG.language.ITALIAN) {
				text.add("La versione italiana non è completa. Waiting ...");
			} else if (language==VG.language.SPANISH) {
				text.add("La versión en español no es completa. Esperando ...");
			} else if (language==VG.language.GERMANY) {
				text.add("Die deutsche Version ist noch nicht gestartet. Waiting ...");
			} else {
			}
			VG.title = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeCountOfSignatures(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("03/2013 - 97.000 signatures");
			} else if (language==VG.language.ITALIAN) {
				text.add("03/2013 - 97.000 firme");
			} else if (language==VG.language.SPANISH) {
				text.add("03/2013 - 97.000 firmas");
			} else if (language==VG.language.GERMANY) {
				text.add("03/2013 - 97.000 unterschriften");
			} else {
				text.add("97.000 sign.<br/>03/2013");
			}
			VG.countOfSignatures = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeStephaneHessel(language language) {
		if (language!=null) {
			ArrayList<String> text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("Appel à signature pour 'Roosevelt 2012' - Stéphane Hessel - 18/05/2012");
			} else if (language==VG.language.ITALIAN) {
				text.add("Appel à signature pour 'Roosevelt 2012' - Stéphane Hessel - 18/05/2012");
			} else if (language==VG.language.SPANISH) {
				text.add("Appel à signature pour 'Roosevelt 2012' - Stéphane Hessel - 18/05/2012");
			} else if (language==VG.language.GERMANY) {
				text.add("Appel à signature pour 'Roosevelt 2012' - Stéphane Hessel - 18/05/2012");
			} else {
				text.add("Appel à signature pour 'Roosevelt 2012' - Stéphane Hessel - 18/05/2012");
			}
			VG.stephaneHessel_text = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeNousAvonsDecideDAgirCorps(Context context, language language) {
		if (context!=null && language!=null) {
			ArrayList<String> text = null;
			text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("« Each one of us, however powerless or insignificant, can change the world, » wrote the late Vaclav Havel, dissident and \"president-philosopher\" of the Czech Republic from 1993 to 2003, a few weeks after the Berlin Wall fell.");
		        text.add("In 1989, \"insignificant\" women and men changed the course of history. Twenty years later, the neoliberal system, in turn, is falling apart. It is up to us, the citizens, to say in what kind of society we aspire to live. A society of injustice and chaos -- or a society of harmony and fraternity? The choice is ours. It is up to us to act.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Click here to see the complete pdf manifest (Internet access)");
		        } else {
		        	text.add("To read the pdf you must have an internet connection.");
		        }
			} else if (language==VG.language.ITALIAN) {
		        text.add("« Ognuno di noi può cambiare il mondo. Anche se non ha nessun potere, anche se non ha la minima importanza, ognuno di noi può cambiare il mondo » scriveva Vaclav Havel poche settimane dopo la caduta del Muro di Berlino.");
		        text.add("Nel 1989, sono donne ed uomini « senza la minima importanza » che hanno cambiato il corso della storia. Vent’anni più tardi, il sistema neoliberale crolla a sua volta. Spetta a noi, cittadini, dire in quale società vogliamo vivere. Società d'ingiustizia e di caos o società di equilibrio e di socievolezza? A noi di scegliere. A noi di agire.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Clicca qui per vedere il manifesto completo pdf (accesso a Internet)");
		        } else {
		        	text.add("Per leggere il file PDF è necessario disporre di una connessione a Internet.");
		        }
			} else if (language==VG.language.SPANISH) {
		        text.add("« Cualquiera puede cambiar el mundo. Aunque no tenga poder, aunque sea alguien sin la menor importancia, cualquiera puede cambiar el mundo » escribía Václav Havel unas semanas después de la caída del Muro de Berlín.");
		        text.add("En 1989, fueron mujeres y hombres \"sin la menor importancia\" los que cambiaron el curso de la Historia. Veinte años más tarde, es el sistema neoliberal el que se hunde. Nos toca a los ciudadanos expresar en que sociedad queremos vivir. ¿Una sociedad de injusticia y caos, o una sociedad de equilibrio y buena convivencia? Nos toca a nosotros escoger. Nos toca a nosotros actuar.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Haga clic aquí para ver el manifiesto completo pdf (acceso a Internet)");
		        } else {
		        	text.add("Para leer el PDF es necesario tener una conexión a internet.");
		        }
			} else if (language==VG.language.GERMANY) {
				text.add("« Chacun de nous peut changer le monde. Même s’il n’a aucun pouvoir, même s’il n’a pas la moindre importance, chacun de nous peut changer le monde » écrivait Václav Havel quelques semaines après la chute du Mur de Berlin.");
		        text.add("En 1989, ce sont des femmes et des hommes \"sans la moindre importance\" qui ont changé le cours de l’Histoire. Vingt ans plus tard, le système néolibéral s’effondre à son tour. C’est à nous, les citoyens, de dire dans quelle société nous voulons vivre. Société d’injustice et de chaos ou société d’équilibre et de convivialité ? A nous de choisir. A nous d’agir.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Cliquez ici pour voir le manifeste complet en pdf (accès internet)");
		        } else {
		        	text.add("Pour lire la suite en pdf, vous devez avoir une connexion internet.");
		        }
			} else {
				text.add("« Chacun de nous peut changer le monde. Même s’il n’a aucun pouvoir, même s’il n’a pas la moindre importance, chacun de nous peut changer le monde » écrivait Václav Havel quelques semaines après la chute du Mur de Berlin.");
		        text.add("En 1989, ce sont des femmes et des hommes \"sans la moindre importance\" qui ont changé le cours de l’Histoire. Vingt ans plus tard, le système néolibéral s’effondre à son tour. C’est à nous, les citoyens, de dire dans quelle société nous voulons vivre. Société d’injustice et de chaos ou société d’équilibre et de convivialité ? A nous de choisir. A nous d’agir.");
		        text.add("");
		        if (Utils.isConnectedToInternet(context)) {
		        	text.add("Cliquez ici pour voir le manifeste complet en pdf (accès internet)");
		        } else {
		        	text.add("Pour lire la suite en pdf, vous devez avoir une connexion internet.");
		        }
			}
			VG.nousAvonsDecideDAgir_Corps = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeNousAvonsDecideDAgirEntete(VG.language language) {
		if (language!=null) {
			ArrayList<String> text = null;
			text = new ArrayList<String>();
			if (language==VG.language.ENGLISH) {
				text.add("<h1>We have decided to take action</h1><h3></h3>");
			} else if (language==VG.language.ITALIAN) {
		        text.add("<h1>Abbamio deciso di agire</h1><h3></h3>");
			} else if (language==VG.language.SPANISH) {
		        text.add("<h1>Hemos decidido actuar</h1><h3></h3>");
			} else if (language==VG.language.GERMANY) {
				text.add("<h1>Nous avons décidé d'agir</h1><h3></h3>");
			} else {
				// By default.
				text.add("<h1>Nous avons décidé d'agir</h1><h3></h3>");
			}
			VG.nousAvonsDecideDAgir_Titre = Utils.createStringWithTabOfStrings(text);
		}
	}
	
	/**
	 * Charg Refom Titles
	 * @param language
	 */
	public static void chargReformTitles(VG.language language) {
		if (language!=null) {
			VG.REFORMS_RUBRICS = new ArrayList<String>();
			VG.REFORMS_TITLE = new ArrayList<Reform>();
		    if (language==VG.language.ENGLISH) {
			    VG.REFORMS_RUBRICS.add("Preventing collapse");
			    VG.REFORMS_RUBRICS.add("Against unemployment, build a new society");
			    VG.REFORMS_RUBRICS.add("Finally build a democratic Europe");
		        VG.REFORMS_TITLE = new ArrayList<Reform>();
		        VG.REFORMS_TITLE.add(new Reform("the collective", null));
		        VG.REFORMS_TITLE.add(new Reform("1 Give our States some room to breathe", "english_reforme01.html"));
		        VG.REFORMS_TITLE.add(new Reform("2 Creation of a European corporate tax on profits", "english_reforme02.html"));
		        VG.REFORMS_TITLE.add(new Reform("3 Bring national tax scuttling to an end", "english_reforme03.html"));
		        VG.REFORMS_TITLE.add(new Reform("4 Boycott tax havens", "english_reforme04.html"));
		        VG.REFORMS_TITLE.add(new Reform("5 Do the utmost to curtail layoffs", "english_reforme05.html"));
		        VG.REFORMS_TITLE.add(new Reform("6 Eliminate social and employment insecurity", "english_reforme06.html"));
		        VG.REFORMS_TITLE.add(new Reform("7 Stop banks from speculating on our moneyn", "english_reforme07.html"));
		        VG.REFORMS_TITLE.add(new Reform("8 Create a real Financial Transactions Tax", "english_reforme08.html"));
		        VG.REFORMS_TITLE.add(new Reform("9 Resist outsourcing", "english_reforme09.html"));
		        VG.REFORMS_TITLE.add(new Reform("10 Invest in a true housing policyn", "english_reforme10.html"));
		        VG.REFORMS_TITLE.add(new Reform("11 Declare war on climate change", "english_reforme11.html"));
		        VG.REFORMS_TITLE.add(new Reform("12 Develop the Social and Solidarity Economy", "english_reforme12.html"));
		        VG.REFORMS_TITLE.add(new Reform("13 Negotiate a new and better way of sharing working time", "english_reforme13.html"));
		        VG.REFORMS_TITLE.add(new Reform("14 Let’s make democracy flower in Europe", "english_reforme14.html"));
		        VG.REFORMS_TITLE.add(new Reform("15 Negotiate a Genuine Treaty for a Social Europe", "english_reforme15.html"));
			    VG.insternetSiteUrl = "http://www.roosevelt2012.com";
			    VG.schemas = "Schémas";
			    VG.jeSigneUrl = "http://www.roosevelt2012.fr/index#jesigne";
			    VG.jeSigne = "I sign";
			    VG.etApresUrl = "http://www.roosevelt2012.fr/agir";
			    VG.etApres = "And after ?";
			    VG.leCollectif = "the Collective";
			    VG.laVideoUrl = "http://www.roosevelt2012.fr/lavideo";
			    VG.laVideo = "The French Video";
			    VG.lesGroupesLocauxUrl = "http://www.roosevelt2012.fr/groupeslocaux";
			    VG.lesGroupesLocaux = "Local French Groups";
			    VG.actualitesUrl = "http://presse.roosevelt2012.fr/";
			    VG.actualites = "French actuality";
			    VG.nousAvonsDecideDAgir_Url = "http://www.roosevelt2012.com/download?fileid=en791264838-mani-pdf";
			    VG.direLExtremeGravite_Url = "http://www.roosevelt2012.com/download?fileid=en791264837-acti-pdf";
		    } else if (language==VG.language.ITALIAN) {
			    VG.REFORMS_RUBRICS.add("Evitare il crollo");
			    VG.REFORMS_RUBRICS.add("In attesa di traduzione");
			    VG.REFORMS_RUBRICS.add("In attesa di traduzione");
			    VG.REFORMS_TITLE.add(new Reform("Il collecttivo", null));
			    VG.REFORMS_TITLE.add(new Reform("1 Ridare ossigeno ai nostri Stati", "italy_reforme01.html"));
			    VG.REFORMS_TITLE.add(new Reform("2 Disporre di nuovi margini di manovra finanziari", "italy_reforme02.html"));
			    VG.REFORMS_TITLE.add(new Reform("3 In attesa di traduzione", "italy_reforme03.html"));
			    VG.REFORMS_TITLE.add(new Reform("4 In attesa di traduzione", "italy_reforme04.html"));
			    VG.REFORMS_TITLE.add(new Reform("5 In attesa di traduzione", "italy_reforme05.html"));
			    VG.REFORMS_TITLE.add(new Reform("6 In attesa di traduzione", "italy_reforme06.html"));
			    VG.REFORMS_TITLE.add(new Reform("7 In attesa di traduzione", "italy_reforme07.html"));
			    VG.REFORMS_TITLE.add(new Reform("8 In attesa di traduzione", "italy_reforme08.html"));
			    VG.REFORMS_TITLE.add(new Reform("9 In attesa di traduzione", "italy_reforme09.html"));
			    VG.REFORMS_TITLE.add(new Reform("10 In attesa di traduzione", "italy_reforme10.html"));
			    VG.REFORMS_TITLE.add(new Reform("11 In attesa di traduzione", "italy_reforme11.html"));
			    VG.REFORMS_TITLE.add(new Reform("12 In attesa di traduzione", "italy_reforme12.html"));
			    VG.REFORMS_TITLE.add(new Reform("13 In attesa di traduzione", "italy_reforme13.html"));
			    VG.REFORMS_TITLE.add(new Reform("14 In attesa di traduzione", "italy_reforme14.html"));
			    VG.REFORMS_TITLE.add(new Reform("15 In attesa di traduzione", "italy_reforme15.html"));
		        VG.insternetSiteUrl = "http://www.roosevelt2012.it/";
		        VG.schemas = "Schémas";
//			    VG.jeSigneEtApresUrl = "http://www.roosevelt2012.fr/index#jesigne";
//		        VG.jeSigneEtApres = "Firmo E dopo?";
			    VG.jeSigneUrl = "http://www.roosevelt2012.fr/index#jesigne";
			    VG.jeSigne = "Firmo";
			    VG.etApresUrl = "http://www.roosevelt2012.fr/agir";
			    VG.etApres = "E dopo?";
		        VG.leCollectif = "Collective";
			    VG.laVideoUrl = "http://www.roosevelt2012.fr/lavideo";
		        VG.laVideo = "Francese Video";
			    VG.lesGroupesLocauxUrl = "http://www.roosevelt2012.fr/groupeslocaux";
		        VG.lesGroupesLocaux = "Francese Gruppi locali";
			    VG.actualitesUrl = "http://presse.roosevelt2012.fr/";
		        VG.actualites = "Francese Attualità";
		        VG.nousAvonsDecideDAgir_Url = "http://www.roosevelt2012.it/scaricare?fileid=it791264838-mani-pdf";
			    VG.direLExtremeGravite_Url = "http://www.roosevelt2012.it/scaricare?fileid=it791264837-agir-pdf";
		    } else if (language==VG.language.SPANISH) {
			    VG.REFORMS_RUBRICS.add("Evitar el colapso");
			    VG.REFORMS_RUBRICS.add("Contra el desempleo, una nueva sociedad");
			    VG.REFORMS_RUBRICS.add("Construir una Europa democratica");
			    VG.REFORMS_TITLE.add(new Reform("El colectivo", null));
			    VG.REFORMS_TITLE.add(new Reform("1 Dejar a nuestros estados que respiren", "spain_reforme01.html"));
			    VG.REFORMS_TITLE.add(new Reform("2 Crear un impuesto europeo sobre los beneficios", "spain_reforme02.html"));
			    VG.REFORMS_TITLE.add(new Reform("3 Poner fin al hundimiento fiscal nacional", "spain_reforme03.html"));
			    VG.REFORMS_TITLE.add(new Reform("4 Boicotear los paraísos fiscales", "spain_reforme04.html"));
			    VG.REFORMS_TITLE.add(new Reform("5 Limitar al máximo los despidos", "spain_reforme05.html"));
			    VG.REFORMS_TITLE.add(new Reform("6 Proteger a los trabajadores precarios", "spain_reforme06.html"));
			    VG.REFORMS_TITLE.add(new Reform("7 Prohibir a los bancos especular con nuestro dinero", "spain_reforme07.html"));
			    VG.REFORMS_TITLE.add(new Reform("8 Crear une verdadera tasa sobre las operaciones financieras", "spain_reforme08.html"));
			    VG.REFORMS_TITLE.add(new Reform("9 Luchar contra las deslocalizaciones", "spain_reforme09.html"));
			    VG.REFORMS_TITLE.add(new Reform("10 Invertir en una verdadera política de vivienda", "spain_reforme10.html"));
			    VG.REFORMS_TITLE.add(new Reform("11 Declarar la guerra al cambio climático", "spain_reforme11.html"));
			    VG.REFORMS_TITLE.add(new Reform("12 Desarrollar la Economia Social y Solidaria", "spain_reforme12.html"));
			    VG.REFORMS_TITLE.add(new Reform("13 Negociar otro reparto del tiempo de trabajo", "spain_reforme13.html"));
			    VG.REFORMS_TITLE.add(new Reform("14 Hacer renacer la Democracia en Europa", "spain_reforme14.html"));
			    VG.REFORMS_TITLE.add(new Reform("15 Negociar un verdadero Tratado de la Europa Social", "spain_reforme15.html"));
		        VG.insternetSiteUrl = "http://www.roosevelt2012.es/";
		        VG.schemas = "Schémas";
//			    VG.jeSigneEtApresUrl = "http://www.roosevelt2012.fr/index#jesigne";
//		        VG.jeSigneEtApres = "Firmo y después ?";
			    VG.jeSigneUrl = "http://www.roosevelt2012.fr/index#jesigne";
			    VG.jeSigne = "Firmo";
			    VG.etApresUrl = "http://www.roosevelt2012.fr/agir";
			    VG.etApres = "Y después ?";
		        VG.leCollectif = "Francés Colectivo";
			    VG.laVideoUrl = "http://www.roosevelt2012.fr/lavideo";
		        VG.laVideo = "Vídeos en Francés";
			    VG.lesGroupesLocauxUrl = "http://www.roosevelt2012.fr/groupeslocaux";
		        VG.lesGroupesLocaux = "Franceses grupos locales";
			    VG.actualitesUrl = "http://presse.roosevelt2012.fr/";
		        VG.actualites = "Noticias francés";
		        VG.nousAvonsDecideDAgir_Url = "http://www.roosevelt2012.es/descargar?fileid=es791264838-mani-pdf";
			    VG.direLExtremeGravite_Url = "http://www.roosevelt2012.es/descargar?fileid=es791264837-actu-pdf";
			} else if (language==VG.language.GERMANY) {
			    VG.REFORMS_RUBRICS.add("Waiting for translation");
			    VG.REFORMS_RUBRICS.add("Waiting for translation");
			    VG.REFORMS_RUBRICS.add("Waiting for translation");
		        VG.REFORMS_TITLE = new ArrayList<Reform>();
		        VG.REFORMS_TITLE.add(new Reform("Le collectif", null));
		        VG.REFORMS_TITLE.add(new Reform("1 Waiting for translation", "germany_reforme01.html"));
		        VG.REFORMS_TITLE.add(new Reform("2 Waiting for translation", "germany_reforme02.html"));
		        VG.REFORMS_TITLE.add(new Reform("3 Waiting for translation", "germany_reforme03.html"));
		        VG.REFORMS_TITLE.add(new Reform("4 Waiting for translation", "germany_reforme04.html"));
		        VG.REFORMS_TITLE.add(new Reform("5 Waiting for translation", "germany_reforme05.html"));
		        VG.REFORMS_TITLE.add(new Reform("6 Waiting for translation", "germany_reforme06.html"));
		        VG.REFORMS_TITLE.add(new Reform("7 Waiting for translation", "germany_reforme07.html"));
		        VG.REFORMS_TITLE.add(new Reform("8 Waiting for translation", "germany_reforme08.html"));
		        VG.REFORMS_TITLE.add(new Reform("9 Waiting for translation", "germany_reforme09.html"));
		        VG.REFORMS_TITLE.add(new Reform("10 Waiting for translation", "germany_reforme10.html"));
		        VG.REFORMS_TITLE.add(new Reform("11 Waiting for translation", "germany_reforme11.html"));
		        VG.REFORMS_TITLE.add(new Reform("12 Waiting for translation", "germany_reforme12.html"));
		        VG.REFORMS_TITLE.add(new Reform("13 Waiting for translation", "germany_reforme13.html"));
		        VG.REFORMS_TITLE.add(new Reform("14 Waiting for translation", "germany_reforme14.html"));
		        VG.REFORMS_TITLE.add(new Reform("15 Waiting for translation", "germany_reforme15.html"));
			    VG.insternetSiteUrl = "http://www.roosevelt2012.fr";
			    VG.schemas = "Schémas";
//			    VG.jeSigneEtApresUrl = "http://www.roosevelt2012.fr/index#jesigne";
//			    VG.jeSigneEtApres = "Ich unterschreibe und nach ?";
			    VG.jeSigneUrl = "http://www.roosevelt2012.fr/index#jesigne";
			    VG.jeSigne = "Ich unterschreibe";
			    VG.etApresUrl = "http://www.roosevelt2012.fr/agir";
			    VG.etApres = "Und nach ?";
			    VG.leCollectif = "Le Collectif";
			    VG.laVideoUrl = "http://www.roosevelt2012.fr/lavideo";
			    VG.laVideo = "das Video";
			    VG.lesGroupesLocauxUrl = "http://www.roosevelt2012.fr/groupeslocaux";
			    VG.lesGroupesLocaux = "Gruppen Lokale Französisch";
			    VG.actualitesUrl = "http://presse.roosevelt2012.fr/";
			    VG.actualites = "Französisch News";
			    VG.nousAvonsDecideDAgir_Url = "http://www.roosevelt2012.fr/telecharger?fileid=45791264838-mani-pdf";
			    VG.direLExtremeGravite_Url = "http://www.roosevelt2012.fr/telecharger?fileid=45791264837-agir-pdf";
		    } else {
		    	// French texts by default.
			    VG.REFORMS_RUBRICS.add("Eviter l'effondrement");
			    VG.REFORMS_RUBRICS.add("Contre le chômage, construire une nouvelle société");
			    VG.REFORMS_RUBRICS.add("Construire enfin une Europe démocratique");
		        VG.REFORMS_TITLE = new ArrayList<Reform>();
		        VG.REFORMS_TITLE.add(new Reform("Le collectif", null));
		        VG.REFORMS_TITLE.add(new Reform("1 Redonner de l'oxygène à nos États", "reforme01.html"));
		        VG.REFORMS_TITLE.add(new Reform("2 Dégager de nouvelles marges de manœuvre financières", "reforme02.html"));
		        VG.REFORMS_TITLE.add(new Reform("3 Mettre fin au sabordage fiscal national", "reforme03.html"));
		        VG.REFORMS_TITLE.add(new Reform("4 Boycotter les paradis fiscaux", "reforme04.html"));
		        VG.REFORMS_TITLE.add(new Reform("5 Limiter au maximum les licenciements", "reforme05.html"));
		        VG.REFORMS_TITLE.add(new Reform("6 Sécuriser les précaires", "reforme06.html"));
		        VG.REFORMS_TITLE.add(new Reform("7 Interdire aux banques de spéculer avec notre argent", "reforme07.html"));
		        VG.REFORMS_TITLE.add(new Reform("8 Créer une vraie Taxe sur les Transactions Financières", "reforme08.html"));
		        VG.REFORMS_TITLE.add(new Reform("9 Lutter contre les délocalisations", "reforme09.html"));
		        VG.REFORMS_TITLE.add(new Reform("10 Investir dans une vraie politique du logement", "reforme10.html"));
		        VG.REFORMS_TITLE.add(new Reform("11 Déclarer la guerre au dérèglement climatique", "reforme11.html"));
		        VG.REFORMS_TITLE.add(new Reform("12 Développer l’économie sociale et solidaire", "reforme12.html"));
		        VG.REFORMS_TITLE.add(new Reform("13 Négocier un autre partage du temps de travail", "reforme13.html"));
		        VG.REFORMS_TITLE.add(new Reform("14 Faire éclore la démocratie en Europe", "reforme14.html"));
		        VG.REFORMS_TITLE.add(new Reform("15 Négocier un vrai Traité de l’Europe sociale", "reforme15.html"));
			    VG.insternetSiteUrl = "http://www.roosevelt2012.fr";
			    VG.schemas = "Schémas";
//			    VG.jeSigneEtApresUrl = "http://www.roosevelt2012.fr/index#jesigne";
//			    VG.jeSigneEtApres = "1.Je signe 2.Et après ?";
			    VG.jeSigneUrl = "http://www.roosevelt2012.fr/index#jesigne";
			    VG.jeSigne = "Je signe";
			    VG.etApresUrl = "http://www.roosevelt2012.fr/agir";
			    VG.etApres = "Et après ?";
			    VG.leCollectif = "Le Collectif";
			    VG.laVideoUrl = "http://www.roosevelt2012.fr/lavideo";
			    VG.laVideo = "La Video";
			    VG.lesGroupesLocauxUrl = "http://www.roosevelt2012.fr/groupeslocaux";
			    VG.lesGroupesLocaux = "Les Groupes locaux";
			    VG.actualitesUrl = "http://presse.roosevelt2012.fr/";
			    VG.actualites = "Actualité";
			    VG.nousAvonsDecideDAgir_Url = "http://www.roosevelt2012.fr/telecharger?fileid=45791264838-mani-pdf";
			    VG.direLExtremeGravite_Url = "http://www.roosevelt2012.fr/telecharger?fileid=45791264837-agir-pdf";
		    }
		}
	}
	
	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeMessageOfMyMentions(VG.language language) {
		if (language!=null) {
			ArrayList<String> text = null;
			text = new ArrayList<String>();
			if (VG.languageChoiced==VG.language.ENGLISH) {
				VG.mesMentions_titre ="About this application";
    			VG.mesMentions_corps ="This application is not an official application.\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Its goals :\n";
    			VG.mesMentions_corps +="- disseminate ideasof the collective \"Roosevelt 2012\"\n";
    			VG.mesMentions_corps +="- able to read the proposed offline and online news offered by the site (see menu bar \"News\")\n";
    			VG.mesMentions_corps +="- allow access to the site of origin www.Roosevelt2012.com\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Notes :\n";
    			VG.mesMentions_corps +="- the internal schema to the 15 proposals are viewable only if the internet connection is open\n";
    			VG.mesMentions_corps +="- the original work is licensed under CC BY-NC-ND 2.0 (see http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="See you soon !\n";
			} else if (VG.languageChoiced==VG.language.ITALIAN) {
				VG.mesMentions_titre = "A proposito di questa applicazione";
				VG.mesMentions_corps = "Ci scusiamo per la traduzione dell'interfaccia (per fortuna, la traduzione di riforme non è fatta da me ...)\n";
				VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Questa applicazione non è un'applicazione ufficiale.\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="I suoi obiettivi :\n";
    			VG.mesMentions_corps +="- diffondere idee del Roosevelt 2012 collettiva\n";
    			VG.mesMentions_corps +="- in grado di leggere le notizie proposta offline e online offerto dal sito (vedi barra dei menu \"Attualità \")\n";
    			VG.mesMentions_corps +="- consentire l'accesso al sito di origine www.Roosevelt2012.fr\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Note :\n";
    			VG.mesMentions_corps +="- lo schema interno alle 15 proposte sono visibili solo se la connessione Internet è aperta\n";
    			VG.mesMentions_corps +="- l'opera originale è sotto licenza CC BY-NC-ND 2.0 (cf http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="A presto !\n";
    			VG.mesMentions_corps +="\n";
			} else if (language==VG.language.SPANISH) {
				VG.mesMentions_titre ="Acerca de esta aplicación";
    			VG.mesMentions_corps ="Esta aplicación no es una aplicación oficial.\n";
    			VG.mesMentions_corps +="Disculpas por la traducción (por suerte, las 15 propuestas no eres yo)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Sus objetivos :\n";
    			VG.mesMentions_corps +="- Oficial difundir ideas del colectivo Roosevelt 2012\n";
    			VG.mesMentions_corps +="- capaz de leer las propuestas internet desconectado y noticias ofrecido por el sitio (barra de menús \"Actualidad\")\n";
    			VG.mesMentions_corps +="- permitir el acceso al sitio original www.Roosevelt2012.fr\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Notas :\n";
    			VG.mesMentions_corps +="- el esquema interno de las 15 propuestas se pueden ver sólo si la conexión a Internet está abierta";
    			VG.mesMentions_corps +="- la obra original es bajo licencia CC BY-NC-ND 2.0 (ver http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Hasta pronto !\n";
			} else if (language==VG.language.GERMANY) {
				VG.mesMentions_titre ="Über diese Anwendung";
    			VG.mesMentions_corps ="Diese Anwendung ist keine offizielle Anwendung.\n";
    			VG.mesMentions_corps +="Entschuldigung für die Übersetzung (glücklicherweise sind die 15 Vorschläge mir nicht übersetzt)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="seine Ziele :\n";
    			VG.mesMentions_corps +="- Offizielle verbreiten Ideen der kollektiven Roosevelt 2012\n";
    			VG.mesMentions_corps +="- der Lage, die geplanten Offline-und Online-Nachrichten von der Website angeboten (Menüleiste \"Aktualität\") zu lesen\n";
    			VG.mesMentions_corps +="- erlauben den Zugriff auf die Website der Herkunft www.Roosevelt2012.fr\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Aufzeichnungen :\n";
    			VG.mesMentions_corps +="- das interne Schema der 15 Vorschläge sind nur angezeigt, wenn die Internet-Verbindung öffnen ist\n";
    			VG.mesMentions_corps +="- die ursprüngliche Arbeit Werk unter CC lizenziert BY-NC-ND 2.0 (siehe http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="\n";
//    			VG.mesMentions_corps +="A bientôt !\n";
			} else {
				VG.mesMentions_titre ="A propos de cette application";
//    			VG.mesMentions_corps ="Cette application n'est pas une application officielle.\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Ses objectifs :\n";
    			VG.mesMentions_corps +="- diffuser les idées du collectif Roosevelt\n";
    			VG.mesMentions_corps +="- fournir les propositions hors connexion internet\n";
//    			VG.mesMentions_corps +="- accéder au site officiel www.Roosevelt2012.fr\n";
    			VG.mesMentions_corps +="- accéder au site officiel\n";
    			VG.mesMentions_corps +="\n";
//    			VG.mesMentions_corps +="Remarques :\n";
//    			VG.mesMentions_corps +="- les schéma internes aux 15 propositions sont visualisables uniquement si la connexion internet est ouverte\n";
//    			VG.mesMentions_corps +="- l'oeuvre d'origine est sous licence CC BY-NC-ND 2.0 (cf http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="Remarque : l'oeuvre d'origine est sous licence CC BY-NC-ND 2.0 (cf http://creativecommons.org/licenses/by-nc-nd/2.0/fr/)\n";
    			VG.mesMentions_corps +="\n";
    			VG.mesMentions_corps +="Pour une nouvelle donne économique, n'oubliez pas de signer, et d'aller voir les sites :\n";
    			VG.mesMentions_corps +="- www.roosevelt2012.fr\n";
    			VG.mesMentions_corps +="- Facebook, Google+\n";
    			VG.mesMentions_corps +="- reseau.nouvelledonne.fr\n";
    			VG.mesMentions_corps +="\nA bientôt\n";
			}
		}
	}

	/**
	 * Valorize Variable
	 * @param language
	 */
	public static void valorizeMyMentions(VG.language language) {
		if (language!=null) {
			ArrayList<String> text = null;
			text = new ArrayList<String>();
			if (VG.languageChoiced==VG.language.ENGLISH) {
				VG.mesMentions_information = "Unofficial application created on 04/08/2012";
				VG.mesMentions_textButton = "About this application";
			} else if (VG.languageChoiced==VG.language.ITALIAN) {
				VG.mesMentions_information = "Ufficiali applicazione creata il 2012/04/08";
				VG.mesMentions_textButton = "A proposito di questa applicazione";
			} else if (VG.languageChoiced==VG.language.SPANISH) {
				VG.mesMentions_information = "No oficiales aplicación creada el 04/08/2012";
				VG.mesMentions_textButton = "Acerca de esta aplicación";
			} else if (VG.languageChoiced==VG.language.GERMANY) {
				VG.mesMentions_information = "Anwendung inoffiziellen auf 2012.04.08 erstellt";
				VG.mesMentions_textButton = "über diese Anwendung";
			} else {
				VG.mesMentions_information = "Application non officielle créée le 04/08/2012";
				VG.mesMentions_textButton = "A propos de cette application";
			}
		}
	}

}
