package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SLongActionState implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("LongActionState");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("progress", int.class));
		sClass.addField(new SField("state", SActionState.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("progress")) {
			return getProgress();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int progress;
	private SActionState state;
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
	public SActionState getState() {
		return state;
	}

	public void setState(SActionState state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
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
		SLongActionState other = (SLongActionState) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}