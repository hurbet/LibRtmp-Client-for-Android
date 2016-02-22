package net.butterflytv.rtmp_client;

/**
 * Created by faraklit on 08.02.2016.
 */
public class RTMPMuxer {

    static {
        System.loadLibrary("rtmp-jni");
    }

    public native int open(String url);

    /**
     * write h264 nal units
     * @param data
     * @param offset
     * @param length
     * @param timestamp
     * @return 0 if it writes network successfully
     * -1 if it could not write
     */
    public native int writeVideo(byte[] data, int offset, int length, int timestamp);

    /**
     * Write raw aac data
     * @param data
     * @param offset
     * @param length
     * @param timestamp
     * @return 0 if it writes network successfully
     * -1 if it could not write
     */
    public native int writeAudio(byte[] data, int offset, int length, int timestamp);

    public native int close();


    public native void write_flv_header(boolean is_have_audio, boolean is_have_video);

    public native void file_open(String filename);

    public native void file_close();
}
