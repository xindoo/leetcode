
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id,emp); 
        }
        return getSubdinatesImportance(map,id);
    }

    public int getSubdinatesImportance(HashMap<Integer,Employee> map, int id){
        if(!map.containsKey(id)) 
            return 0;
        int res = 0;
        Employee emp = map.get(id);
        if (emp.subordinates == null) {
            return emp.importance; 
        }
        for (int subId : emp.subordinates) {
            res += getSubdinatesImportance(map,subId); 
        }
        return emp.importance + res;
    }
}