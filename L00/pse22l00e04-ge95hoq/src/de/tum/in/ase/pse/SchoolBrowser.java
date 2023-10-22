package de.tum.in.ase.pse;

import java.net.MalformedURLException;
import java.util.*;

public final class SchoolBrowser {

	private static final int TEACHER_ID_MRS_SCHNEIDER = 934543895;
	private static final int TEACHER_ID_MR_MUELLER = 37984283;

	private SchoolBrowser() {
	}

	public static void main(String[] args) throws MalformedURLException {
		Set<String> denylistedHosts = Set.of("www.facebook.com", "www.instagram.com", "www.reddit.com");
//		Set<Integer> teacherIDs = Set.of(TEACHER_ID_MRS_SCHNEIDER, TEACHER_ID_MR_MUELLER);
		System.out.println("The SchoolBrowser does not allow connections to the following hosts: " + denylistedHosts);
//		URL redirectPage = new URL("https://www.exzellenz.tum.de/startseite/");

		/*
		SchoolProxy schoolProxy = new SchoolProxy(denylistedHosts, redirectPage, teacherIDs);

		schoolProxy.connect(new URL("https://www.google.com/search?q=pinguine"));
		schoolProxy.disconnect();

		// this page is not allowed for students
		schoolProxy.connect(new URL("https://www.instagram.com/tu.muenchen"));
		schoolProxy.disconnect();

		// authorize as teacher in order to access pages of denylisted hosts
		schoolProxy.login(TEACHER_ID_MRS_SCHNEIDER);
		schoolProxy.connect(new URL("https://www.instagram.com/tu.muenchen"));
		schoolProxy.disconnect();
		 */
	}
}
