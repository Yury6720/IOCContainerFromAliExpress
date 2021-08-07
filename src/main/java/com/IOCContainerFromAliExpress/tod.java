package com.IOCContainerFromAliExpress;

public class tod extends OF{

  public static void main(String[] args) {
      new tod();
    System.out.println("2");
  }
}

 abstract class OF extends Wood {
    public OF() {

        super("oak");
        System.out.println("1");
    }
}
 abstract class Wood {
    private String type;

    public Wood(String type) {
        System.out.println(this.getClass()+ "3");
        this.type = type;
    }
}