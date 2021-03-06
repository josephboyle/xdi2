package xdi2.messaging.util;

import xdi2.core.xri3.impl.XRI3Segment;
import xdi2.core.xri3.impl.XRI3SubSegment;

/**
 * A class that provides various constants for XDI messaging.
 * 
 * @author markus
 */
public final class XDIMessagingConstants {

	public static final XRI3Segment XRI_S_ANONYMOUS = new XRI3Segment("$");
	public static final XRI3Segment XRI_S_SELF = new XRI3Segment("$");

	public static final XRI3Segment XRI_S_MSG = new XRI3Segment("$msg");
	public static final XRI3Segment XRI_S_GET = new XRI3Segment("$get");
	public static final XRI3Segment XRI_S_ADD = new XRI3Segment("$add");
	public static final XRI3Segment XRI_S_MOD = new XRI3Segment("$mod");
	public static final XRI3Segment XRI_S_DEL = new XRI3Segment("$del");
	public static final XRI3Segment XRI_S_DO = new XRI3Segment("$do");

	public static final XRI3SubSegment XRI_SS_MSG = new XRI3SubSegment("$msg");
	public static final XRI3SubSegment XRI_SS_GET = new XRI3SubSegment("$get");
	public static final XRI3SubSegment XRI_SS_ADD = new XRI3SubSegment("$add");
	public static final XRI3SubSegment XRI_SS_MOD = new XRI3SubSegment("$mod");
	public static final XRI3SubSegment XRI_SS_DEL = new XRI3SubSegment("$del");
	public static final XRI3SubSegment XRI_SS_DO = new XRI3SubSegment("$do");

	private XDIMessagingConstants() { }
}
