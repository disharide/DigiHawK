package controllers;

import java.util.ArrayList;
import java.util.List;

import models.LocationObj;
import models.PhoneObj;
import models.SmsObj;

import org.json.JSONObject;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import entity.LocationLog;
import entity.PhoneLog;
import entity.SmsLog;

public class ParentAppController extends Controller {

	public Result getPhoneLogForChild(Long childId) {
		List<PhoneLog> phoneLogs = PhoneLog.find.where().eq("user.id", childId)
				.findList();

		JSONObject allPhoneRecord = new JSONObject();
		List<PhoneObj> phoneRecords = new ArrayList<>();

		for (PhoneLog phoneLog : phoneLogs) {
			PhoneObj phoneRecord = new PhoneObj();
			phoneRecord.phoneNumber = phoneLog.phoneNumber;
			phoneRecord.duration = phoneLog.duration;
			phoneRecord.type = phoneLog.type.name();
			phoneRecord.userId = phoneLog.user.id;
			phoneRecord.timeInMillis = phoneLog.timeInMillis;

			phoneRecords.add(phoneRecord);
		}

		allPhoneRecord.put("phoneLog", phoneRecords);

		return ok(Json.parse(allPhoneRecord.toString()));
	}

	public Result getSmsLogForChild(Long childId) {
		List<SmsLog> smsLogs = SmsLog.find.where().eq("user.id", childId)
				.findList();

		JSONObject allSmsRecord = new JSONObject();
		List<SmsObj> smsRecords = new ArrayList<>();

		for (SmsLog smsLog : smsLogs) {
			SmsObj smsRecord = new SmsObj();
			smsRecord.phoneNumber = smsLog.phoneNumber;
			smsRecord.text = smsLog.text;
			smsRecord.type = smsLog.type.name();
			smsRecord.userId = smsLog.user.id;
			smsRecord.timeInMillis = smsLog.timeInMillis;

			smsRecords.add(smsRecord);
		}

		allSmsRecord.put("smsLog", smsRecords);

		return ok(Json.parse(allSmsRecord.toString()));
	}

	public Result getLocationForChild(Long childId) {
		List<LocationLog> locations = LocationLog.find.where().eq("user.id", childId)
				.findList();

		JSONObject allLocations = new JSONObject();
		List<LocationObj> locationObjs = new ArrayList<>();

		for (LocationLog location : locations) {
			LocationObj locationObj = new LocationObj();
			locationObj.latitude = location.latitude;
			locationObj.longitude = location.longitude;
			locationObj.userId = location.user.id;
			locationObj.timeInMillis = location.timeInMillis;

			locationObjs.add(locationObj);
		}

		allLocations.put("locations", locationObjs);

		return ok(Json.parse(allLocations.toString()));
	}
}
