/**
 * 
 */
package com.vraj.playground.architecture.monitoring;

/**
 * Indicates dimension to catogarize log level.
 * 
 * @author vrajori
 *
 */
public class Dimension {

	private String dimensionName;
	private int dimensionLevel;

	Dimension(String name, int level) {
		this.dimensionName = name;
		this.dimensionLevel = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dimensionLevel;
		result = prime * result + ((dimensionName == null) ? 0 : dimensionName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		if (dimensionLevel != other.dimensionLevel)
			return false;
		if (dimensionName == null) {
			if (other.dimensionName != null)
				return false;
		} else if (!dimensionName.equals(other.dimensionName))
			return false;
		return true;
	}

}
