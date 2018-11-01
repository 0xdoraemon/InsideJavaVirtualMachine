jar cvmf manifests/mf2a.txt ex2a.jar Example2a.class
jar cvmf manifests/mf2b.txt ex2b.jar Example2b.class
jar cvmf manifests/mf2c.txt ex2c.jar Example2c.class
jar cvmf manifests/mf2d.txt ex2d.jar Example2d.class

jar cvf self.jar QuestionWriter.class AnswerReader.class com/artima/security/doer/Doer.class

jarsigner -keystore ijvmkeys -storepass ijvm2ed -keypass self4life self.jar self
jarsigner -keystore ijvmkeys -storepass ijvm2ed -keypass self4life ex2a.jar self
jarsigner -keystore ijvmkeys -storepass ijvm2ed -keypass self4life ex2b.jar self
jarsigner -keystore ijvmkeys -storepass ijvm2ed -keypass self4life ex2c.jar self
jarsigner -keystore ijvmkeys -storepass ijvm2ed -keypass self4life ex2d.jar self

