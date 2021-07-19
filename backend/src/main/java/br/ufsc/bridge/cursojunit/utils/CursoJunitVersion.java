package br.ufsc.bridge.cursojunit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;

@Getter
public class CursoJunitVersion implements Comparable<CursoJunitVersion> {

	private String raw;

	private int major;
	private int minor;
	private int patch;

	public CursoJunitVersion(String raw) {
		this.raw = raw;
		this.parse();
	}

	private void parse() {
		if (StringUtils.isBlank(this.raw)) {
			return;
		}

		Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+).(\\d+)");
		Matcher m = pattern.matcher(this.raw);
		if (m.find()) {
			this.major = Integer.parseInt(m.group(1));
			this.minor = Integer.parseInt(m.group(2));
			this.patch = Integer.parseInt(m.group(3));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CursoJunitVersion)) {
			return false;
		}

		return this.compareTo((CursoJunitVersion) obj) == 0;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public int compareTo(CursoJunitVersion version) {
		if (this.toLong() < version.toLong()) {
			return -1;
		}

		if (this.toLong() > version.toLong()) {
			return 1;
		}

		return 0;
	}

	public Long toLong() {
		return Long.parseLong(String.format("%d%d%d", this.major, this.minor, this.patch));
	}

	@Override
	public String toString() {
		return this.getRaw();
	}

}
