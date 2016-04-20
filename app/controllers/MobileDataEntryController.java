package controllers;

import java.util.Map;

import models.LocationObj;
import models.PhoneObj;
import models.Service;
import models.SmsObj;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import entity.CommunicationType;
import entity.Location;
import entity.PhoneLog;
import entity.SmsLog;
import entity.User;

public class MobileDataEntryController extends Controller {

	@BodyParser.Of(value = BodyParser.FormUrlEncoded.class)
	public Result storePhoneLog() {
		Service service = new Service();

		Map<String, String[]> phoneLogMap = request().body().asFormUrlEncoded();

		Logger.info("map " + phoneLogMap.get("phonelog")[0]);

		PhoneObj phoneObj = Json.fromJson(
				Json.parse(phoneLogMap.get("phonelog")[0]), PhoneObj.class);

		PhoneLog phoneLog = new PhoneLog();

		User user = User.find.byId(phoneObj.userId);

		phoneLog.phoneNumber = phoneObj.phoneNumber;
		phoneLog.duration = phoneObj.duration;
		phoneLog.timeInMillis = phoneObj.timeInMillis;
		if ("OUTGOING".equalsIgnoreCase(phoneObj.type)) {
			phoneLog.callType = CommunicationType.OUTGOING;
		} else {
			phoneLog.callType = CommunicationType.INCOMING;
		}

		phoneLog.user = user;

		phoneLog.save();

		service.status = "Record successfully stored";

		return ok(Json.toJson(service));
	}

	@BodyParser.Of(value = BodyParser.FormUrlEncoded.class)
	public Result storeSmsLog() {
		Service service = new Service();
		try {

			Map<String, String[]> smsLogMap = request().body()
					.asFormUrlEncoded();
			// Logger.info("map " + smsLogMap.get("smsLog")[0]);

			Logger.info("sms map " + smsLogMap.get("smsLog"));

			SmsObj smsObj = Json.fromJson(
					Json.parse(smsLogMap.get("smsLog")[0]), SmsObj.class);

			SmsLog smsLog = new SmsLog();

			User user = User.find.byId(smsObj.userId);

			smsLog.phoneNumber = smsObj.phoneNumber;
			smsLog.text = smsObj.text;
			smsLog.timeInMillis = smsObj.timeInMillis;
			if ("OUTGOING".equalsIgnoreCase(smsObj.type)) {
				smsLog.smsType = CommunicationType.OUTGOING;
			} else {
				smsLog.smsType = CommunicationType.INCOMING;
			}

			smsLog.user = user;

			smsLog.save();

			service.status = "Record successfully stored";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok(Json.toJson(service));
	}

	@BodyParser.Of(value = BodyParser.FormUrlEncoded.class)
	public Result storeLocation() {
		Service service = new Service();

		Map<String, String[]> locationMap = request().body().asFormUrlEncoded();

		LocationObj locationObj = Json.fromJson(
				Json.parse(locationMap.get("location")[0]), LocationObj.class);

		Location location = new Location();

		User user = User.find.byId(locationObj.userId);

		location.latitude = locationObj.latitude;
		location.longitude = locationObj.longitude;
		location.timeInMillis = locationObj.timeInMillis;

		location.user = user;

		location.save();

		service.status = "Record successfully stored";

		return ok(Json.toJson(service));
	}
}
