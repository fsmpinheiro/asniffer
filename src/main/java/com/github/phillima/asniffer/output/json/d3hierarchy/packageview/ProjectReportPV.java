package com.github.phillima.asniffer.output.json.d3hierarchy.packageview;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import com.github.phillima.asniffer.output.json.d3hierarchy.Children;

public class ProjectReportPV {
	
	
	@SerializedName(value = "name")
	private String projectName;

	@SerializedName(value = "children")
	private List<Children> packagesJSON;
	
	public ProjectReportPV(String projectName) {
		this.projectName = projectName;
		this.packagesJSON = new ArrayList<Children>();
	}

	public void addPackageJSON(Children packageJSON) {
		this.packagesJSON.add(packageJSON);
	}

	public void addPackages(List<Children> packages) {
		this.packagesJSON = packages;
		
	}

}