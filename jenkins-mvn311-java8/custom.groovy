name = "jdk1.8.0_40";
home = "/jdk1.8.0_40";
list = null;

dis = new hudson.model.JDK.DescriptorImpl();
dis.setInstallations( new hudson.model.JDK(name, home));

println "JDK settings updated!"