Нэр: Азтүшиг 
Оюутны код: B232270014


Java version: 

java version "23.0.2" 2025-01-21

Java(TM) SE Runtime Environment (build 23.0.2+7-58)

Java HotSpot(TM) 64-Bit Server VM (build 23.0.2+7-58, mixed mode, sharing)


mvn version: 

Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)

Maven home: C:\\apache-maven-3.9.9

Java version: 23.0.2, vendor: Oracle Corporation, runtime: C:\\jdk-23.0.2

Default locale: en\_US, platform encoding: UTF-8

OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"



\## Хэсэг A болон B-г result хэсэгт оруулсан болно.

\## Хэсэг C — Давталтын зааг (0 / 1 / 2+)



`gpa()` доторх давталтад Лекц 9-ийн 0 / 1 / 2+ дүрмийг хэрэгжүүлсэн гурван төрлийн тест:



\- 0 удаа: `loop\_zero\_emptyArray\_throws` ба `loop\_zero\_nullArray\_throws` (хоёулаа assertThrows)

\- 1 удаа: `loop\_one\_singleScore` — gpa(\[95]) = 4.0

\- 2+ удаа: `loop\_many\_multipleScores` — gpa(\[95, 85, 75, 65]) = 2.5



Эдгээр тест хамралтын тоог өсгөөгүй, учир нь бүх мөр, салаа өмнөх тестүүдээр

аль хэдийн хамрагдсан байсан. Гэсэн ч хоосон, нэг элементтэй, олон элементтэй

массивт давталт өөр өөрөөр ажилладаг тул эдгээр гурван тохиолдол тусдаа

алдааг барьж чадна.



\## Хэсэг D — Хамралт 100% боловч алдаатай



Зааг утгын тест нэмээд `mvn clean test` ажиллуулахад 33 тестээс 1 нь унав

(`results/mvn-test-D-fail.txt`):



```

ScholarshipCalculatorTest.boundary\_60\_isD:153 expected: <D> but was: <F>

```



Шалтгаан: `ScholarshipCalculator.letterGrade()` дотор `if (score > 60) return "D";`

гэж бичсэн байсан бол спецификаци 60-69.99-ыг "D" гэдэг. Засвар: `>` -ийг `>=`

болгосон. Засварын commit: `Fix letterGrade boundary condition: > 60 -> >= 60, spec says 60 is D`.



\### Дүгнэлт



Branch хамралт 100% байхад энэ алдаа үл үзэгдэгч байсан. Учир нь

`score > 60` ба `score >= 60` хоёр ижил үнэн, худал салааг үүсгэдэг бөгөөд

65, 30 гэх мэт онооны тест хоёр кодыг адилхан хамруулдаг. Хамралт нь кодын

мөр, салаа ажилласан эсэхийг хэмждэг боловч буцаасан утга спецификацитай

таарч байгааг хэмждэггүй. Яг 60 онооны зааг утгын тест л ялгааг илрүүлсэн.

Иймээс хамралт нь хэрэгтэй хэрэгсэл боловч зөв байхын хангалттай нотолгоо

биш болж таарсан, зааг утгын тест хэрэгтэй.

