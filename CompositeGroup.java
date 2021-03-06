import java.util.ArrayList;

public class CompositeGroup {

	GUI main_GUI;
	public int group_id;
	public ArrayList<MainObject> plain_obj; 	// 存放一般的物件（例如： Class, Use Case...）
	public ArrayList<CompositeGroup> sub_group; // 存放Group底下的Group 
	public CompositeGroup parent = null; //上層的Group(父Group)

	public CompositeGroup(int group_id, GUI m) {
		this.main_GUI = m;
		this.group_id = group_id;
		this.plain_obj = new ArrayList<MainObject>();
		this.sub_group = new ArrayList<CompositeGroup>();
	}


	public void add_plain_obj(MainObject obj){
		obj.group_belong = this;
		this.plain_obj.add(obj);
	}


	public void add_sub_group(CompositeGroup group_belong){
		// 往上找出他的祖宗十八代，並且把最上層的root group加進這個新Group底下
		CompositeGroup root_group = this.get_root_group(group_belong);
		
		// 這個血統的Group已經加過了
		if(root_group == this){
			return;
		}

		root_group.parent = this;
		this.sub_group.add(root_group);

	}


	public static CompositeGroup get_root_group(CompositeGroup group){
		if (group==null || group.parent == null) {
			return group;
		}

		return get_root_group(group.parent);
	}

	public void select_all_object_relative(CompositeGroup obj_group_belong){
		System.out.println("select_all_object_relative: ");
		// 把這個Group的Plain Object也Select起來
		for (MainObject obj : obj_group_belong.plain_obj) {
			// 如果selected_object裡面沒有加過這個物件
			if(!this.main_GUI.selected_object.contains(obj)){
				this.main_GUI.selected_object.add(obj);
			}
		}

		// 往下檢查所有的sub Group，把裡面的Plain Object也Select起來
		for (CompositeGroup sub_group : obj_group_belong.sub_group) {
			select_all_object_relative(sub_group);
		}


	}

	//解構掉這個Group(傳進來的obj_group會是root group)
	public static void decomposite_latest_group(CompositeGroup obj_group){
		for (MainObject obj : obj_group.plain_obj) {
			obj.group_belong = null;
		}

		for (CompositeGroup group : obj_group.sub_group) {
			group.parent = null;
		}

	}

}
