class Names{
	String name;
	Names(String name){
		this.name = name;
	}
}
class NamesMain{
	public static void main(String args[]){
		Object obj = new Names("Assail");
		//Object obj = names;
		//names = (Names)obj;
		//System.out.println(names.name);
		System.out.println(obj.name);
	}
}
