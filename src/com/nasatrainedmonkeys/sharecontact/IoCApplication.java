package com.nasatrainedmonkeys.sharecontact;

import java.util.List;

import roboguice.application.RoboApplication;

import com.google.inject.Module;

public class IoCApplication extends RoboApplication {
	
	@Override
	protected void addApplicationModules(List<Module> modules) {
		super.addApplicationModules(modules);
		modules.add(new IoCModule());
	}

}
