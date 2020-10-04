public class XiaoSanTrack {
    private Map<Integer, Person> potentialXiaoSanMap;

    public addXiaoSan(int person_id) {
        Person potentialXiaoSan = personMap.get(person_id);
        potentialXiaoSanMap.put(person_id, Person);
    }
}

public class TestDriver {
    XiaoSanTrack track = new XiaoSanTrack();

    public static void main(String[] args) {
        try {
            this.track.addXiaoSan(0);//person_id: 0. name:"Boyang Hou"
        } catch (MaleCadidateException e) {
            System.out.println(e.getMessage());
        }
    }
}