package net.dongliu.apk.parser.struct.signingv2;

public class Signature {

  private final int algorithmID;
  private final byte[] data;

  public Signature(int algorithmID, byte[] data) {
    this.algorithmID = algorithmID;
    this.data = data;
  }

  public int getAlgorithmID() {
    return algorithmID;
  }

  public byte[] getData() {
    return data;
  }
}
