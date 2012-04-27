package com.claybook.ios;
import java.util.List;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.log4j.BasicConfigurator;
import org.json.JSONException;

public class PushIt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        BasicConfigurator.configure();
	 } catch (Exception e) {
	 }
		
		PushNotificationPayload payload = PushNotificationPayload.complex();
		
		
		
		
		try {
			// the total payload is restricted to 250 bytes, intelligently truncate the message to 115 bytes to be safe
			String message = "Todd Marshall sent you a NOOM!\n\"The next one's on me! this is an extra super long message because I need to see where it is truncated. Or if it even is truncated, or what the hell happens";
			message = message.substring(0, 110);
			if (message.length() == 110)
				message = message + "...\"";
			
			payload.addAlert(message);
			payload.addBadge(1); // this needs to be the *total* number of nooms that are waiting for approval
			payload.addSound("default");
			payload.addCustomDictionary("type", "INC");
			payload.addCustomDictionary("fromPartyId", "111111111");
			
			List<PushedNotification>notifications = Push.payload(payload, "/Users/sgs/Repository/2-Client/2-NOOM/Keys/NOOMDevPush.p12", "#G1v3$N00m!", false, "8a77e2f113661148fcfd5214b15d51abfbc9e9a9efd10757941269e899b7658d");
			
		} catch (CommunicationException e) {

			e.printStackTrace();
		} catch (KeystoreException e) {

			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
