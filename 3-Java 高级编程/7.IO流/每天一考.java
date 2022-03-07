/*
	1. 如何遍历 Map 的 key 集，value 集，key-value 集，使用上泛型

		Map<String, Integer> map = new HashMap<>();

		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println(key);
		}

		Collection<Integer> values = map.vaules();
		Iterator<Integer> iterator = values.iterator();
		while(iterator.hasNext()){
			int value = iterator.next();
			System.out.println(value);
		}

		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry entry : entryValue){
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext){
			Map.Entry<String, Integer> entry = iterator.next();
			String key = entry.getKey();
			Integer value = entry,getValue();
			System.out.println(key + "--->" + value);
		}


	2. 写出使用 Iterator 和增强 for 循环遍历 List<String> 的代码，使用上泛型
		
		List<String> list = new ArrayList<>();

		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			System.out.println(s);
		}

		for(String s : list){
			System.out.println(s);
		}


	3. 提供一个方法，用于遍历获取 HashMap<String, String> 中的所有 value，并存放在 List 中返回。考虑集合中泛型的使用

		public List<String> getValuesList(HashMap<String, String> map){
			Collection<String> coll = map.values();
			return new ArrayList<>(coll);
		}

		public List<String> getValuesList(HashMap<String, String> map){
			List<String> valueList = new ArrayList<>();
			Collection<String> values = map.values();
			for(String value : values){
				valueList.add(value);
			}
			return valueList;
		}


	4. 创建一个与 a.txt 文件同目录下的另外一个文件 b.txt

		File file1 = new File("...");// 存放 a.txt 的文件目录
		File file2 = new File(file1.getParent(), "b.txt");

		file2.createNewFile();


	5. Map 接口中的常用方法有哪些？

		添加：put(K key,V value)

        删除：V remove(K key)

        修改：put(K key, V value)

        查询：V get(K key)

        长度： int size()

        遍历：keySet() / values() / entrySet()


*/