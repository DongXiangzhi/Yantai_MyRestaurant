package cn.edu.ldu.myrestaurant.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ldu.myrestaurant.model.Product;


public class SampleDataProvider {
    public static List<Product> dataItemList;
    public static Map<String,Product> dataItemMap;

    static {
            dataItemList=new ArrayList<>();
            dataItemMap=new HashMap<>();
        addItem(new Product(null, "拌三鲜", "冷拼", "主料：黑木耳、西芹、银耳。\n\n" +
                "【1】黑木耳口感细嫩，味道鲜美，风味特殊，是一种营养丰富的著名食用菌，有“食品阿司匹林”之称。主要功效：益气、润肺、补脑、轻身、凉血、止血、涩肠、活血、养颜等。\n\n" +
                "【2】西芹又名西洋芹菜，营养丰富，富含蛋白质、碳水化合物、矿物质及多种维生素等营养物质，具有降血压、镇静、健胃、利尿等疗效，是一种保健蔬菜。\n\n" +
                "【3】银耳味甘、淡、性平、无毒，既有补脾开胃的功效，又有益气清肠、滋阴润肺的作用。既能增强人体免疫力，又可增强肿瘤患者对放、化疗的耐受力。银耳富有天然植物性胶质，是可以长期服用的良好润肤食品。\n\n", 1, 20, "bansanxian.jpg"));
        addItem(new Product(null, "蛋黄南瓜", "点心", "主料：蛋黄、南瓜。\n\n" +
                "【蛋黄】蛋黄中有宝贵的维生素A和维生素D，还有维生素E和维生素K，这些都是“脂溶性维生素”。水溶性的维生素B族，也绝大多数存在于蛋黄之中。蛋黄之所以呈浅黄色，是因为它含有核黄素，而核黄素就是维生素B2，它可以预防烂嘴角、舌炎、嘴唇裂口等。\n\n" +
                "各种微量元素也集中在蛋黄中。蛋黄中有大量的磷，还有不少的铁。同时，鸡蛋中所有的卵磷脂均来自蛋黄，而卵磷脂可以提供胆碱，帮助合成一种重要的神经递质——乙酰胆碱。所以，婴儿的第一种辅食，往往就是鸡蛋黄。蛋黄对孩子补铁有益，对孩子的大脑发育也有益。\n\n" +
                "【南瓜】南瓜多糖是一种非特异性免疫增强剂，能提高机体免疫功能，促进细胞因子生成，通过活化补体等途径对免疫系统发挥多方面的调节功能。\n\n" +
                "南瓜中丰富的类胡萝卜素在机体内可转化成具有重要生理功能的维生素A，从而对上皮组织的生长分化、维持正常视觉、促进骨骼的发育具有重要生理功能。\n\n" +
                "南瓜中的果胶能调节胃内食物的吸收速率，使糖类吸收减慢，可溶性纤维素能推迟胃内食物的排空，控制饭后血糖上升。果胶还能和体内多余的胆固醇结合在一起，使胆固醇吸收减少，血胆固醇浓度下降。\n\n" +
                "南瓜含有丰富的钴，在各类蔬菜中含钴量居首位。钴能活跃人体的新陈代谢，促进造血功能，并参与人体内维生素B12的合成，是人体胰岛细胞所必须的微量元素。南瓜中所含的维生素C能防止硝酸盐在消化道中转变成致癌物质亚硝酸。\n\n" +
                "南瓜中含有的甘露醇，减少粪便中毒素对人体的危害。南瓜能消除致癌物质亚硝胺的突变作用。有防癌功效。南瓜中含有丰富锌，参与人体内核酸、蛋白质合成，是肾上腺皮质激素的固有成分，为人体生长发育的重要物质。\n\n" +
                "南瓜中含有人体所需的多种氨基酸，其中赖氨酸、亮氨酸、异亮氨酸、苯丙氨酸、苏氨酸等含量较高。此外，南瓜中的抗坏血酸氧化酶基因型与烟草中相同，但活性明显高于烟草，表明了在南瓜中免疫活性蛋白的含量较高。\n\n", 2, 15, "danhuangnangua.jpg"));
        addItem(new Product(null, "海参", "海鲜", "主料：海参、薏米、油菜。\n\n" +
                "【1】海参同人参、燕窝、鱼翅齐名，是世界八大珍品之一。海参不仅是珍贵的食品，也是名贵的药材。据《本草纲目拾遗》记载：海参，味甘咸，补肾，益精髓，摄小便，壮阳疗痿，其性温补，足敌人参，故名海参。海参具有提高记忆力、延缓性腺衰老，防止动脉硬化以及抗肿瘤等作用。随着海参价值知识的普及，海参逐渐进入百姓餐桌。生活环境决定海参品质。\n\n" +
                "【2】薏米性味甘淡微寒，有利水消肿、健脾去湿、舒筋除痹、清热排脓等功效，为常用的利水渗湿药。薏仁又是一种美容食品，常食可以保持人体皮肤光泽细腻，消除粉刺、雀斑、老年斑、妊娠斑、蝴蝶斑，对脱屑、痤疮、皲裂、皮肤粗糙等都有良好疗效。\n\n" +
                "【3】降低血脂：油菜为低脂肪蔬菜，且含有膳食纤维，能与胆酸盐和食物中的胆固醇及甘油三酯结合，并从粪便中排出，从而减少脂类的吸收，故可用来降血脂。中医认为油菜能活血化瘀、散血消肿的作用，可用于孕妇产后淤血腹痛以及治疗疖肿、丹毒。\n\n" +
                "解毒消肿：油菜中所含的植物激素，能够增加酶的形成，对进入人体内的致癌物质有吸附排斥作用，故有防癌功能。此外，还具有促进血液循环，增强肝脏的排毒机制，对皮肤疮疖、乳痈有治疗作用。\n\n" +
                "宽肠通便：油菜中含有大量的植物纤维素，能促进肠道蠕动，增加粪便的体积，缩短粪便在肠腔停留的时间，从而治疗多种便秘，预防肠道肿瘤。主治游风丹毒、手足疖肿、乳痈、习惯性便秘、老年人缺钙等病症。\n\n" +
                "美容保健：油菜中含有的维生素C、胡萝卜素是人体黏膜及上皮组织维持生长的重要营养物质，常食具有美容作用。油菜所含钙量在绿叶蔬菜中为最高，一个成年人一天吃500克油菜，其所含钙、铁、维生素A和C即可满足生理需求。另外油菜还有助于增强机体免疫能力。\n\n", 3, 50, "haishen.jpg"));
        addItem(new Product(null, "海鲜汇", "海鲜", "主料：基围虾、香菇、蟹味菇。\n\n" +
                "【1】基围虾营养丰富，其肉质松软，易消化，对身体虚弱以及病后需要调养的人是极好的食物；虾中含有丰富的镁，能很好的保护心血管系统，它可减少血液中胆固醇含量，防止动脉硬化，同时还能扩张冠状动脉，有利于预防高血压及心肌梗死；虾肉还有补肾壮阳，通乳抗毒、养血固精、化瘀解毒、益气滋阳、通络止痛、开胃化痰等功效。\n\n" +
                "【2】香菇，又名花菇、香蕈、香信、香菌、冬菇、香菰，为侧耳科植物香蕈的子实体。香菇是世界第二大食用菌，也是我国特产之一，在民间素有“山珍”之称。它是一种生长在木材上的真菌。味道鲜美，香气沁人，营养丰富。香菇富含维生素B群、铁、钾、维生素D原（经日晒后转成维生素D）、味甘，性平。主治食欲减退，少气乏力。\n\n" +
                "香菇素有山珍之王之称，是高蛋白、低脂肪的营养保健食品。中国历代医学家对香菇均有著名论述。现代医学和营养学不断深入研究，香菇的药用价值也不断被发掘。香菇中麦角甾醇含量很高，对防治佝偻病有效；香菇多糖（β～1，3葡聚糖）能增强细胞免疫能力，从而抑制癌细胞的生长；香菇含有六大酶类的40多种酶，可以纠正人体酶缺乏症；香菇中的脂肪所含脂肪酸，对人体降低血脂有益。\n\n" +
                "【3】蟹味菇含有丰富维生素和17种氨基酸，其中赖氨酸、精氨酸的含量高于一般菇类，有助于青少年益智增高，抗癌、降低胆固醇。特别是子实体（即根以上部分）的提取物具有多种生理活性成份。其中真菌多糖、嘌呤、腺苷能增强免疫力，促进抗体形成抗氧化成分能延缓衰老、美容等等。\n\n" +
                "蟹味菇（真姬菇）子实体中提取的β-1，3-D葡聚糖具有很高的抗肿瘤活性，而且从真姬菇中分离得到的聚合糖酶的活性也比其它菇类要高许多，其子实体热水提取物和有机溶剂提取物有清除体内自由基作用，因此，有防止便秘、抗癌、防癌、提高免疫力、预防衰老、延长寿命的独特功效。是一种低热量、低脂肪的保健食品。\n\n", 4, 60, "haixian.jpg"));
        addItem(new Product(null, "基围虾", "海鲜", "主料：基围虾。\n\n" +
                "基围虾营养丰富，其肉质松软，易消化，对身体虚弱以及病后需要调养的人是极好的食物；虾中含有丰富的镁，能很好的保护心血管系统，它可减少血液中胆固醇含量，防止动脉硬化，同时还能扩张冠状动脉，有利于预防高血压及心肌梗死；虾肉还有补肾壮阳，通乳抗毒、养血固精、化瘀解毒、益气滋阳、通络止痛、开胃化痰等功效。\n\n", 5, 30, "jiweixia.jpg"));
        addItem(new Product(null, "烤猪排", "烧烤", "主料：猪排骨。\n\n" +
                "猪排骨营养丰富，提供人体生理活动必需的优质蛋白质、脂肪，尤其是丰富的钙质可维护骨骼健康。一般人都可食用，湿热痰滞内蕴者慎服，肥胖、血脂较高者不宜多食。\n\n", 6, 40, "kaozhupai.jpg"));
        addItem(new Product(null, "扣肉", "红烧", "主料：五花肉。\n\n" +
                "扣肉的主料为五花肉，发源于广东，以梅菜扣肉最为著名，一般狭义的扣肉就指梅菜扣肉。是梅州传统特产，色泽金黄，香气扑鼻，清甜爽口，不寒不燥不湿不热，被传为“正气”菜而久负盛名。五花肉味甘咸、性平，入脾、胃、肾经;滋阴润燥，补肾养血。肥胖、血脂较高者不宜多食。\n\n", 7, 20, "kourou.jpg"));
        addItem(new Product(null, "苦瓜蛋片", "面食", "主料：鸡蛋、苦瓜、面粉。\n\n" +
                "【1】鸡蛋又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富，一个鸡蛋重约50克，含蛋白质7克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。\n\n" +
                "鸡蛋有很高的营养价值，是优质蛋白质、B族维生素的良好来源，还能提供一定数量的脂肪、维生素A和矿物质。一个中等大小的鸡蛋可提供6克左右的优质蛋白质，是各种食物中所含蛋白质最高的。\n\n" +
                "【2】苦瓜清热解毒：苦瓜能泄去心中烦热，排除体内毒素。苦瓜最好的吃法还是凉拌。凉拌能够很好地保留苦瓜中所含有的维生素。如果用清炒的方法，会使这些维生素在清炒的过程中大量丢失，而且清炒后油的含量比较高，人们食用后会摄入较多的油脂，不能起到清凉败火的作用。\n\n" +
                "养颜嫩肤：常吃苦瓜能增强皮层活力，使皮肤变得细嫩健美。用鲜苦瓜捣汁或煎汤，对肝火赤目、胃脘痛、湿热痢疾，皆为辅助食疗佳品；取鲜苦瓜捣烂外敷，可治疗痈肿、疖疮；夏天小儿易患痱子，将苦瓜切片试擦身上的痱子，可早日痊愈；苦瓜煮水或作美食，可散热解暑。\n\n" +
                "降血糖：蚌肉苦瓜汤是降血糖上品。苦瓜粗提取物含类似胰岛素物质，有明显的降血糖作用。中医认为，苦瓜性味甘苦寒凉，能清热、除烦、止渴；蚌肉甘咸而寒，能清热滋阴、止渴利尿。两者合用，清热滋阴，适用糖尿病偏于胃阴虚有热者。\n\n" +
                "养血滋肝：苦瓜味苦，生则性寒，熟则性温。生食清暑泻火，解热除烦；熟食养血滋肝，润脾补肾，能除邪热、解劳乏、清心明目、益气壮阳。但吃苦瓜也应注意不要损伤脾肺之气。尽管夏天天气炎热，但人们也不可吃太多苦味食物，并且最好搭配辛味的食物（如辣椒、胡椒、葱、蒜），这样可避免苦味入心，有助于补益肺气。\n\n", 8, 15, "kuguadanpian.jpg"));
        addItem(new Product(null, "拌面", "面食", "主料：面条、煎蛋、面酱。\n\n" +
                "【1】面条起源于中国，已有四千多年的制作食用历史。面条是一种制作简单，食用方便，营养丰富，即可主食又可快餐的健康保健食品。\n\n" +
                "【2】煎蛋鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易被机体吸收，利用率高达98%以上，营养价值很高。鸡蛋中钙、磷、铁和维生素A含量很高，B族维生素也很丰富，还含有其它许多种人体必需的维生素和微量元素。\n\n" +
                "油煎鸡蛋过老，鸡蛋清所含的高分子蛋白质会变成低分子氨基酸，这种氨基酸在高温下常可形成对人体健康不利的化学物质。\n\n" +
                "【3】面酱含淀粉、糊精、麦芽糖、葡萄糖、蛋白质、氨基酸、脂肪酶、果胶酶、肽酶、纤维素酶等营养元素。\n\n" +
                "面酱经历了特殊的发酵加工过程，它的甜味来自发酵过程中产生的麦芽糖、葡萄糖等物质，鲜味来自蛋白质分解产生的氨基酸。面酱含有多种风味物质和营养物，不仅滋味鲜美，而且可以丰富菜肴营养，增加可食性，具有开胃助食的功效。\n\n" +
                "面酱老少皆宜，适用于烹饪酱爆和酱烧菜，还可蘸食大葱、黄瓜、烤鸭等菜品。\n\n", 9, 10, "miantiao.jpg"));
        addItem(new Product(null, "牛腩土豆", "红烧", "主料：牛腩、土豆。\n\n" +
                "【1】牛腩是指带有筋、肉、油花的肉块，即牛腹部及靠近牛肋处的松软肌肉，味甘，性平；归脾、胃经；牛肉具有补脾胃、益气血、强筋骨、消水肿等功效。老年人将牛肉与仙人掌同食，可起到抗癌止痛、提高机体免疫功能的效果；牛肉加红枣炖服，则有助肌肉生长和促伤口愈合之功效。\n\n" +
                "【2】土豆又名马铃薯。新鲜马铃薯中所含成分：淀粉9～20%，蛋白质1.5～2.3%，脂肪0.1～1.1%，粗纤维0.6～0.8%。100g马铃薯中所含的营养成分：能量318千焦，钙5～8mg，磷15～40mg，铁0.4mg～0.8mg，钾200~340mg,碘0.8~1.2，胡萝卜素12~30mg，硫胺素0.03～0.08mg，核黄素0.01～0.04mg，尼克酸0.4～1.1mg。\n\n" +
                "马铃薯块茎含有大量的淀粉。淀粉是食用马铃薯的主要能量来源。一般早熟种马铃薯含有11%～14%的淀粉，中晚熟种含有14%～20%的淀粉，高淀粉品种的块茎可达25%以上。块茎还含有葡萄糖、果糖和蔗糖等。\n\n" +
                "中医认为马铃薯“性平味甘无毒，能健脾和胃，益气调中，缓急止痛，通利大便。对脾胃虚弱、消化不良、肠胃不和、脘腹作痛、大便不畅的患者效果显著”。现代研究证明，马铃薯对调解消化不良有特效，是胃病和心脏病患者的良药及优质保健品。马铃薯富有营养，是抗衰老的食物之一。\n\n", 10, 30, "niunan.jpg"));
        addItem(new Product(null, "泡椒", "冷拼", "主料：红辣椒、西芹。\n\n" +
                "【1】红辣椒含有丰富的维生素等，食用辣椒，能增加饭量，增强体力，改善怕冷、冻伤、血管性头痛等症状。辣椒含有一种物殊物质，能加速新陈代谢，促进荷尔蒙分泌，保健皮肤。富含维生素C，可以控制心脏病及冠状动脉硬化，降低胆固醇。含有较多抗氧化物质，可预防癌症及其他慢性疾病。可以使呼吸道畅通，用以治疗咳嗽、感冒。辣椒还能杀抑胃腹内的寄生虫。\n\n" +
                "一般人群均可食用。阴虚有热者勿食；因红辣椒具有较强的刺激性，容易引起口干、咳嗽、咽痛、便秘等。同时眼疾患者、食管炎、胃肠炎、胃溃疡、痔疮患者应少吃或忌食；另外除有火热病症或阴虚火旺外，高血压病，肺结核病患者也应慎食。\n\n" +
                "【2】西芹又名西洋芹菜，营养丰富，富含蛋白质、碳水化合物、矿物质及多种维生素等营养物质，具有降血压、镇静、健胃、利尿等疗效，是一种保健蔬菜。\n\n" +
                "银耳味甘、淡、性平、无毒，既有补脾开胃的功效，又有益气清肠、滋阴润肺的作用。既能增强人体免疫力，又可增强肿瘤患者对放、化疗的耐受力。银耳富有天然植物性胶质，是可以长期服用的良好润肤食品。\n\n", 11, 9, "paojiao.jpg"));
        addItem(new Product(null, "羊肉串", "烧烤", "主料：羊肉、孜然。\n\n" +
                "【1】羊肉性温。既能御风寒，又可补身体，对一般风寒咳嗽、慢性气管炎、虚寒哮喘、肾亏阳痿、腹部冷痛、体虚怕冷、腰膝酸软、面黄肌瘦、气血两亏、病后或产后身体虚亏等一切虚状均有治疗和补益效果，最适宜于冬季食用，故被称为冬令补品，深受人们欢迎。\n\n" +
                "李时珍在《本草纲目》中说：“羊肉能暖中补虚，补中益气，开胃健身，益肾气，养胆明目，治虚劳寒冷，五劳七伤”。\n\n" +
                "【2】孜然为调味品之王，适宜肉类烹调，也可以作为香料使用。孜然的果实可入药，用于治疗消化不良和胃寒腹痛等症。孜然含有生物碱、黄酮及其甙类、皂甙等成分，孜然籽中含多糖9.68%、脂肪16.31%、蛋白质27.06%，还含有丰富的K、Zn、Ca、Mg、Cu、Fe、Mn等维持体内正常功能的矿物元素。孜然籽营养价值较高,是一种很好的风味小吃调料品和药用植物。\n\n" +
                "孜然具有特殊的香味，是为新疆名特小吃烤羊肉配制咖喱粉的主要香料，其风味成分枯茗醛，即对异丙基苯甲醛，是食用香料，也具有安神、止痛、行气、开胃、防腐等医疗保健功能，是新疆重要的民族药。该药有驱风散寒、暖胃健脾、利水逐水，散结水肿等功效，可治疗胃寒呃逆，食欲不振，腹泻腹胀，胃腹胀痛，淋病，小便不利，血凝经闭，睾丸肿胀，疝气等疾病。此外，孜然的提取物制成的复方卡力孜然酊可治疗白癜风。\n\n", 12, 28, "rouchuan.jpg"));
        addItem(new Product(null, "薯条", "煎炸", "主料：薯条、番茄酱。\n\n" +
                "【1】2003年8月26日，美国加州总检察长比尔-洛克耶尔对9家著名连锁快餐店和食品制造商提起诉讼，要求法庭强制它们用警告性标签标明其炸薯条、薯片中致癌物丙烯酰胺的含量。这位加州最高检察官称，他并不是鼓动人们不吃炸薯条，但消费者有权知道他们所吃的炸薯条中有超量的致癌物质。“我并不是在告诉人们，不要吃薯条和薯片。以我个人的生活经验，我知道，这些零食可能不是健康饮食的必要组成部分，但它们确实味道不错。但是我和所有消费者都应掌握必须的信息，以便对我们所吃的食品做出有凭有据的判断。”2002年，瑞典科学家首次证实，土豆等富含淀粉的食物在高温烹炸下会产生过量丙烯酰胺，这使炸薯条和薯片对健康的危害第一次被认识到。但是，炸薯条和薯片作为美式快餐的“国粹”，仍然受到大多数美国人的偏爱。\n\n" +
                "【2】番茄酱是鲜番茄的酱状浓缩制品，最早于19世纪由中国人发明。呈鲜红色酱体，具番茄的特有风味，是一种富有特色的调味品，一般不直接入口。番茄酱由成熟红番茄经破碎、打浆、去除皮和籽等粗硬物质后，经浓缩、装罐、杀菌而成。番茄酱常用作鱼、肉等食物的烹饪佐料，是增色、添酸、助鲜、郁香的调味佳品。番茄酱的运用，是形成港粤菜风味特色的一个重要调味内容。\n\n" +
                "番茄酱中除了番茄红素外还有B族维生素、膳食纤维、矿物质、蛋白质及天然果胶等，和新鲜番茄相比较，番茄酱里的营养成分更容易被人体吸收。\n\n", 13, 12, "shutiao.jpg"));
        addItem(new Product(null, "松子玉米", "热炒", "主料：松子、西芹、玉米等。\n\n" +
                "【1】松子又名松实、果松子、海松子，是松科植物红松等的种子，是常见的坚果之一。富含脂肪、蛋白质、碳水化合物等。是重要的中药，久食健身心，滋润皮肤，延年益寿，也有很高的食疗价值。\n\n" +
                "【2】西芹又名西洋芹菜，营养丰富，富含蛋白质、碳水化合物、矿物质及多种维生素等营养物质，具有降血压、镇静、健胃、利尿等疗效，是一种保健蔬菜。\n\n" +
                "银耳味甘、淡、性平、无毒，既有补脾开胃的功效，又有益气清肠、滋阴润肺的作用。既能增强人体免疫力，又可增强肿瘤患者对放、化疗的耐受力。银耳富有天然植物性胶质，是可以长期服用的良好润肤食品。\n\n" +
                "【3】玉米的营养成分比较全面，一般含蛋白质8.5%、脂肪4.3%、糖类73.2%、钙0.022%、磷.21%、铁0.0016%，还含有胡萝卜素、维生素B1、B2和尼克酸以及谷固醇、卵磷脂、维生素E、赖氨酸等。最新研究指出，玉米中含有一种杭癌因子—谷胱甘肽。国内外苦养学家给予玉米很高的评价，认为：玉米中所含谷胱甘肽其有杭癌作用,它可与人体内多种致癌物质结合,能使这些物质失去致癌性；玉米中所含纤维素是一种不能为人体吸收的碳水化合物，可降低人的肠道内致癌物质的浓度，并减少分泌毒素的腐质在肠道内的积累,从而减少结肠癌和直肠癌的发病率；玉米中所含木质素，可使人体内的“巨噬细胞”的活力提高2~3倍，从而抑制癌瘤的发生；玉米中还含大量的矿物质镁，食物中的镁具有明显的防癌效果。日本遗传学家确认：玉来糠可使二硝基茂致癌物质及煎烤鱼、肉时形成的杂环胺的诱癌变作用降低92%。\n\n", 14, 19, "songziyumi.jpg"));
        addItem(new Product(null, "拌笋丝", "冷拼", "主料：笋丝、西芹、胡萝卜。\n\n" +
                "【1】在中国自古被当作“菜中珍品”。竹笋是中国传统佳肴，味香质脆，食用和栽培历史极为悠久。《诗经》中就有“加豆之实，笋菹鱼醢”、“其籁伊何，惟笋及蒲”等诗句，表明了人民食用竹笋有2500年以至3000年的历史。\n\n" +
                "中医认为竹笋味甘、微寒，无毒。在药用上具有清热化痰、益气和胃、治消渴、利水道、利膈爽胃等功效。竹笋还具有低脂肪、低糖、多纤维的特点，食用竹笋不仅能促进肠道蠕动，帮助消化，去积食，防便秘，并有预防大肠癌的功效。\n\n" +
                "【2】西芹又名西洋芹菜，营养丰富，富含蛋白质、碳水化合物、矿物质及多种维生素等营养物质，具有降血压、镇静、健胃、利尿等疗效，是一种保健蔬菜。\n\n" +
                "银耳味甘、淡、性平、无毒，既有补脾开胃的功效，又有益气清肠、滋阴润肺的作用。既能增强人体免疫力，又可增强肿瘤患者对放、化疗的耐受力。银耳富有天然植物性胶质，是可以长期服用的良好润肤食品。\n\n" +
                "【3】胡萝卜是一种质脆味美、营养丰富的家常蔬菜，素有“小人参”之称。胡萝卜富含糖类、脂肪、挥发油、胡萝卜素、维生素A、维生素B1、维生素B2、花青素、钙、铁等营养成分。\n\n" +
                "每100克胡萝卜中，约含蛋白质0.6克，脂肪0.3克，糖类7.6-8.3克，铁0.6毫克，维生素A原（胡萝卜素）1.35-17.25毫克，维生素B10.02-0.04毫克，维生素B20.04-0.05毫克，维生素C12毫克，热量150.7千焦，另含果胶、淀粉、无机盐和多种氨基酸。各类品种中，尤以深橘红色胡萝卜素含量最高。美国科学家研究证实：每天吃两根胡萝卜，可使血中胆固醇降低10%-20%;每天吃三根胡萝卜，有助于预防心脏疾病和肿瘤。\n\n", 15, 16, "sunsi.jpg"));
        addItem(new Product(null, "糖醋里脊", "煎炸", "主料：精肉。\n\n" +
                "各种瘦肉所含营养成分相近且较肥肉易于消化。约含蛋白质20%，脂肪1－15%，无机盐1%，其余水分。一般来说，猪肉、牛肉、羊肉都含饱和脂肪较高，禽肉、鸡及兔肉中含饱和脂肪较少。同时含无机盐丰富,尤以含铁（红色瘦肉）、磷、钾、钠等较多,唯含钙较少。瘦肉也是维生素B1、B2、B12、PP的良好来源，瘦猪肉中的维生素B1含量相当高，不过，含维生素A却很少，几乎不含维生素C。\n\n" +
                "民间流传着“肉管三天，汤管一七”的说法，即认为肉汤中的营养高于汤中肉的营养，这种看法需要纠正。肉汤中含有瘦肉中部分水溶性物质，如无机盐和水溶性维生素等；也有少量的水溶性蛋白质和水解产物，如肽和一些氨基酸；还有一些含氮浸出物,如肌酐、肌酸、肌肽和嘌吟等。这些氨基酸和含氮物质能使汤味鲜美，它们溶解愈多，汤味愈浓，能刺激人体胃液分泌，增进食欲。但瘦肉中所含的绝大部分营养物质，仍存留在肉中，肉的营养价值肯定是比汤高的。\n\n", 16, 28, "tangcu.jpg"));
        addItem(new Product(null, "土豆辣椒", "热炒", "主料：土豆、青椒、红辣椒。\n\n" +
                "【1】土豆又名马铃薯。新鲜马铃薯中所含成分：淀粉9～20%，蛋白质1.5～2.3%，脂肪0.1～1.1%，粗纤维0.6～0.8%。100g马铃薯中所含的营养成分：能量318千焦，钙5～8mg，磷15～40mg，铁0.4mg～0.8mg，钾200~340mg,碘0.8~1.2，胡萝卜素12~30mg，硫胺素0.03～0.08mg，核黄素0.01～0.04mg，尼克酸0.4～1.1mg。\n\n" +
                "马铃薯块茎含有大量的淀粉。淀粉是食用马铃薯的主要能量来源。一般早熟种马铃薯含有11%～14%的淀粉，中晚熟种含有14%～20%的淀粉，高淀粉品种的块茎可达25%以上。块茎还含有葡萄糖、果糖和蔗糖等。\n\n" +
                "中医认为马铃薯“性平味甘无毒，能健脾和胃，益气调中，缓急止痛，通利大便。对脾胃虚弱、消化不良、肠胃不和、脘腹作痛、大便不畅的患者效果显著”。现代研究证明，马铃薯对调解消化不良有特效，是胃病和心脏病患者的良药及优质保健品。马铃薯富有营养，是抗衰老的食物之一。\n\n" +
                "【2】青椒和红色辣椒统称为辣椒。果实为浆果。别名很多，大椒、灯笼椒、柿子椒都是它的名字，因能结甜味浆果，又叫甜椒、菜椒。\n\n" +
                "一年生或多年生草本植物，特点是果实较大，辣味较淡甚至根本不辣，作蔬菜食用而不作为调味料。由于它翠绿鲜艳，新培育出来的品种还有红、黄、紫等多种颜色，因此不但能自成一菜，还被广泛用于配菜。青椒由原产中南美洲热带地区的辣椒在北美演化而来，经长期栽培驯化和人工选择，使果实发生体积增大，果肉变厚，辣味消失和心皮及子房腔数增多等性状变化。中国于100多年前引入，现全国各地普遍栽培，青椒含有丰富的维生素C，适合高血压高血脂的人群食用。\n\n" +
                "【3】红辣椒含有丰富的维生素等，食用辣椒，能增加饭量，增强体力，改善怕冷、冻伤、血管性头痛等症状。辣椒含有一种物殊物质，能加速新陈代谢，促进荷尔蒙分泌，保健皮肤。富含维生素C，可以控制心脏病及冠状动脉硬化，降低胆固醇。含有较多抗氧化物质，可预防癌症及其他慢性疾病。可以使呼吸道畅通，用以治疗咳嗽、感冒。辣椒还能杀抑胃腹内的寄生虫。\n\n" +
                "一般人群均可食用。阴虚有热者勿食；因红辣椒具有较强的刺激性，容易引起口干、咳嗽、咽痛、便秘等。同时眼疾患者、食管炎、胃肠炎、胃溃疡、痔疮患者应少吃或忌食；另外除有火热病症或阴虚火旺外，高血压病，肺结核病患者也应慎食。\n\n", 17, 12, "tudou.jpg"));
        addItem(new Product(null, "香芋地瓜球", "煎炸", "主料：香芋、地瓜粉、面粉。\n\n" +
                "【1】香芋，又称地栗子、黄栗芋，泽泻目天南星科芋属，淡味、灰白色，常用于中菜或中式甜品，其地方品种槟榔芋常被称为香芋。\n\n" +
                "香芋的食用部分球状块根，外观似小土豆，直径一般2～4厘米，表皮黄褐色，其肉似薯类，但味道好似板栗，甘而芳香，食后余味不尽，故名香芋。香芋营养丰富，淀粉、蛋白质及矿物质含量均较高。据报道，每100g香芋中含淀粉约21g、粗蛋白3.5g、钙含量约为52mg、硒2.2mg、维生素C约7mg。\n\n" +
                "香芋烹煮方法种，烧、炒、炖皆可，用其与鸡肉、猪肉一起炖、烧，其味香而不腻，酥而不烂。历来是逢年过节、喜庆筵席上必备的上乘菜肴。\n\n" +
                "【2】地瓜又名红薯、番薯、山芋、红芋、甘薯、番芋、地瓜（北方）、红苕（多地方言）、线苕、白薯、金薯、甜薯、朱薯、枕薯、番葛、白芋、茴芋地瓜、红皮番薯、山药（方言）、萌番薯等。\n\n" +
                "红薯富含蛋白质、淀粉、果胶、纤维素、氨基酸、维生素及多种矿物质，有“长寿食品”之誉。含糖量达到15%-20%。有抗癌、保护心脏、预防肺气肿、糖尿病、减肥等功效。明代李时珍《本草纲目》记有“甘薯补虚，健脾开胃，强肾阴”，并说海中之人食之长寿。中医视红薯为良药。", 18, 18, "xiangyudigua.jpg"));
        addItem(new Product(null, "西红柿炒蛋", "热炒", "主料：西红柿、鸡蛋。\n\n" +
                "【1】据营养学家研究测定：每人每天食用50克-100克鲜番茄，即可满足人体对几种维生素和矿物质的需要。番茄含的“番茄素”，有抑制细菌的作用；含的苹果酸、柠檬酸和糖类，有助消化的功能。番茄含有丰富的营养，又有多种功用被称为神奇的菜中之果。番茄内的苹果酸和柠檬酸等有机酸，还有增加胃液酸度，帮助消化，调整胃肠功能的作用。番茄中含有果酸，能降低胆固醇的含量，对高血脂症很有益处。番茄富含维生素A、维生素C、维生素B1，维生素B2以及胡萝卜素和钙、磷、钾、镁、铁、锌、铜和碘等多种元素，还含有蛋白质、糖类、有机酸、纤维素。\n\n" + "每100克番茄的营养成分能量11千卡，维生素B0.06毫克，蛋白质0.9克，脂肪0.2克，碳水化合物3.3克，叶酸5.6微克，膳食纤维1.9克，维生素A63微克，胡萝卜素375微克，硫胺素0.02毫克，核黄素0.01毫克，烟酸0.49毫克，维生素C14毫克，维生素E0.42毫克，钙4毫克，磷24毫克，钾179毫克，钠9.7毫克，碘2.5微克，镁12毫克，铁0.2毫克，锌0.12毫克，铜0.04毫克，锰0.06毫克。\n\n" + "【2】鸡蛋又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富，一个鸡蛋重约50克，含蛋白质7克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。\n\n" + "鸡蛋有很高的营养价值，是优质蛋白质、B族维生素的良好来源，还能提供一定数量的脂肪、维生素A和矿物质。一个中等大小的鸡蛋可提供6克左右的优质蛋白质，是各种食物中所含蛋白质最高的。", 19, 10, "xihongshichaodan.jpg"));
        addItem(new Product(null, "烤羊排", "烧烤", "主料：羊排、孜然。\n\n" + "【1】羊排是指羊的肋条即连着肋骨的肉，外覆一层层薄膜，肥瘦结合，质地松软。适于扒、烧、焖和制馅等。羊排，不仅是西餐厅桌上的常客，也是西方家庭主妇们惯用的烹饪食材。\n\n" + "羊肉性温，冬季常吃羊肉，不仅可以增加人体热量，抵御寒冷，而且还能增加消化酶，保护胃壁，修复胃粘膜，帮助脾胃消化，起到抗衰老的作用。\n\n" + "羊肉营养丰富，对肺结核、气管炎、哮喘、贫血、产后气血两虚、腹部冷痛、体虚畏寒、营养不良、腰膝酸软、阳痿早泄以及一切虚寒病症均有很大裨益；具有补肾壮阳、补虚温中等作用，男士适合经常食用。\n\n" + "【2】孜然为调味品之王，适宜肉类烹调，也可以作为香料使用。孜然的果实可入药，用于治疗消化不良和胃寒腹痛等症。孜然含有生物碱、黄酮及其甙类、皂甙等成分，孜然籽中含多糖9.68%、脂肪16.31%、蛋白质27.06%，还含有丰富的K、Zn、Ca、Mg、Cu、Fe、Mn等维持体内正常功能的矿物元素。孜然籽营养价值较高,是一种很好的风味小吃调料品和药用植物。\n\n" + "孜然具有特殊的香味，是为新疆名特小吃烤羊肉配制咖喱粉的主要香料，其风味成分枯茗醛，即对异丙基苯甲醛，是食用香料，也具有安神、止痛、行气、开胃、防腐等医疗保健功能，是新疆重要的民族药。该药有驱风散寒、暖胃健脾、利水逐水，散结水肿等功效，可治疗胃寒呃逆，食欲不振，腹泻腹胀，胃腹胀痛，淋病，小便不利，血凝经闭，睾丸肿胀，疝气等疾病。此外，孜然的提取物制成的复方卡力孜然酊可治疗白癜风。", 20, 40, "yangpai.jpg"));
        addItem(new Product(null, "北京烤鸭", "烧烤", "主料：北京烤鸭。\n\n" + "北京烤鸭享誉海内外，历史悠久，距今已经160多年，号称天下第一吃，是清代宫廷御菜。北京鸭属水禽，肉质细腻，口感良好，营养丰富，含有大量的不饱和脂肪酸，在人体内不积蓄，人体吸收后能软化心脑血管。该鸭的表皮中含有大量的胶原蛋白，是美容佳品。因此，北京烤鸭是老少皆宜的保健美食！现以北京前门大街的全聚德饭店挂炉烤鸭与便宜坊饭店所制焖炉烤鸭为佳。\n\n" + "烤鸭是北京名食，它以色泽红艳，肉质细嫩，味道醇厚，肥而不腻的特色，被誉为“天下美味”而驰名中外。风味特点：色泽略黄，柔软淡香，夹卷其他荤素食物用，为宴席常用面点，更是家常风味小吃。\n\n" + "烤鸭历史悠久，起源于中国南北朝时期，当时《食珍录》中已记有炙鸭。朱元璋建都南京后，明宫御厨便取用南京肥厚多肉的湖鸭制作菜肴。为了增加鸭菜的风味，厨师采用炭火烘烤，成菜后鸭子吃口酥香，肥而不腻，受到人们称赞，即被宫廷取名为“烤鸭”。\n\n" + "\"北京烤鸭\"营养丰富，每百克含蛋白质19.2克、脂肪41克、水分36.2克、维生素B1、B2和钙、磷、铁、铜、锰、锌等微量元素及18种氨基酸。", 21, 30, "yazi.jpg"));
        addItem(new Product(null, "剁椒鱼头", "清蒸", "主料：鲢鱼头、红椒。\n\n" + "【1】鲢鱼头肉质细嫩、营养丰富，除了含蛋白质、脂肪、钙、磷、铁、维生素B1，它还含有鱼肉中所缺乏的卵磷脂，该物质被机体代谢后能分解出胆碱，最后合成乙酰胆碱，乙酰胆碱是神经元之间化学物质传送信息的一种最重要的“神经递质”，可增强记忆、思维和分析能力，让人变得聪明。\n\n" + "鲢鱼头含丰富的不饱和脂肪酸，它对脑的发育尤为重要，可使大脑细胞异常活跃，故使推理、判断力极大增强，因此，常吃鱼头不仅可以健脑，而且还可延缓脑力衰退。\n\n" + "鱼鳃下边的肉呈透明的胶状，里面富含胶原蛋白，能够对抗人体老化及修补身体细胞组织。\n\n" + "2】红椒是菜椒的培育变种，属于茄科。有辛香味，能去除菜肴中的腥味，营养价值甚高，具有御寒、增强食欲、杀菌的功效。\n\n" +
                "除了含有丰富的胡萝卜素外，一根红辣椒还大约含有5000个国际单位的维生素A，可满足成年人的每天需求量，此外还含有超过100毫克的维生素C。这些丰富的抗氧化剂，能中和体内的有害氧分子自由基，有益于人体健康。", 22, 35, "yutou.jpg"));
        addItem(new Product(null, "红烧猪手", "红烧", "主料：猪蹄。\n\n" +
                "猪蹄，是指猪的脚部（蹄）和小腿，在中国又叫元蹄。在华人世界中，猪蹄是猪常被人食用的部位之一，有多种不同的烹调作法。猪蹄含有丰富的胶原蛋白质，脂肪含量也比肥肉低。它能防治皮肤干瘪起皱、增强皮肤弹性和韧性，对延缓衰老和促进儿童生长发育都具有特殊意义。为此，人们把猪蹄称为“美容食品”和“类似于熊掌的美味佳肴”。\n\n" +
                "猪蹄中含有较多的蛋白质、脂肪和碳水化合物，并含有钙、磷、镁、铁以及维生素A、维生素D、维生素E、维生素K等有益成分。它含有丰富的胶原蛋白质，含胆固醇。\n\n" +
                "\"猪蹄\"的营养素含量（指100克可食部食品中的含量）：热量（千卡）259、硫胺素（毫克）0.05、钙（毫克）33、蛋白质（克）23.6、核黄素（毫克）0.1、镁（毫克）5、脂肪（克）18.8、烟酸（毫克）1.5、铁（毫克）1.1、碳水化合物（克）0、维生素C（毫克）0、锰（毫克）0.01。", 23, 38, "zhushou.jpg"));
        addItem(new Product(null, "生菜", "凉菜", "主料：生菜。\n\n" +
                "生菜性质甘凉，因其茎叶中含有莴苣素，故味微苦，有清热提神、镇痛催眠、降低胆固醇、辅助治疗神经衰弱等功效。生菜中含有甘露醇等有效成分，有利尿和促进血液循环、清肝利胆及养胃的功效。生菜中含有干扰素诱生剂，可以刺激人体正常细胞产生干扰素，抵抗病毒，提高人体的免疫力。\n\n" +
                "生菜中含有一种叫原儿茶酸的物质，它对癌细胞有明显的抑制作用，尤其在抵制胃癌、肝癌、大肠癌等消化系统癌症方面，效果显著。\n\n" +
                "生菜中的维生素E、胡萝卜素等，能保护眼睛，维持正常的视力，缓解眼睛干涩与疲劳。\n\n" +
                "生菜中含有丰富的维生素C，具有一点的美白的功效。\n\n" +
                "生菜中的膳食纤维等营养物质含量很高，常食有消除多余脂肪的作用，所以生菜又有减肥生菜的美誉。\n\n" +
                "生菜营养含量丰富，含有大量β胡萝卜素、抗氧化物、维生素B1、B6、维生素E、维生素C，还有大量膳食纤维素和微量元素如镁、磷、钙及少量的铁、铜、锌。加强蛋白质和脂肪的消化与吸收，改善肠胃的血液循环可以常吃生菜。", 24, 9.8, "shengcai.jpg"));
        addItem(new Product(null, "清炒油菜", "热炒", "主料：油菜。\n\n" +
                "降低血脂：油菜为低脂肪蔬菜，且含有膳食纤维，能与胆酸盐和食物中的胆固醇及甘油三酯结合，并从粪便中排出，从而减少脂类的吸收，故可用来降血脂。中医认为油菜能活血化瘀、散血消肿的作用，可用于孕妇产后淤血腹痛以及治疗疖肿、丹毒。\n\n" +
                "解毒消肿：油菜中所含的植物激素，能够增加酶的形成，对进入人体内的致癌物质有吸附排斥作用，故有防癌功能。此外，还具有促进血液循环，增强肝脏的排毒机制，对皮肤疮疖、乳痈有治疗作用。\n\n" +
                "宽肠通便：油菜中含有大量的植物纤维素，能促进肠道蠕动，增加粪便的体积，缩短粪便在肠腔停留的时间，从而治疗多种便秘，预防肠道肿瘤。主治游风丹毒、手足疖肿、乳痈、习惯性便秘、老年人缺钙等病症。\n\n" +
                "美容保健：油菜中含有的维生素C、胡萝卜素是人体黏膜及上皮组织维持生长的重要营养物质，常食具有美容作用。油菜所含钙量在绿叶蔬菜中为最高，一个成年人一天吃500克油菜，其所含钙、铁、维生素A和C即可满足生理需求。另外油菜还有助于增强机体免疫能力。", 25, 12.5, "youcai.jpg"));
        }
    private static void addItem(Product item) {
        dataItemList.add(item);
        dataItemMap.put(item.getItemId(),item);
    }
}
