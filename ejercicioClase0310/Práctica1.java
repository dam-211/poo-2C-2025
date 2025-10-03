class Course {
  private final String code;
  private final List<Section> sections = new ArrayList<>();
  public void add(Section s) { sections.add(s); }
}
class Section {
  private final Course course;
  private final List<Student> students = new ArrayList<>();
}
class Student { private String legajo; }
