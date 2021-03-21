package org.geminicraft.betterwitch.witches.nmsgoals;

import net.minecraft.server.v1_16_R2.EntityInsentient;
import net.minecraft.server.v1_16_R2.PathfinderGoal;
import net.minecraft.server.v1_16_R2.PathfinderGoalSelector;
import org.geminicraft.betterwitch.AIGoalsAnnotation;
import org.geminicraft.betterwitch.ParamsFileHandler;
import org.geminicraft.betterwitch.pathfinders.PathfinderGoalTest;
import org.geminicraft.betterwitch.reflections.Reflections;
import org.geminicraft.betterwitch.reflections.scanners.SubTypesScanner;
import org.geminicraft.betterwitch.reflections.scanners.TypeAnnotationsScanner;
import org.geminicraft.betterwitch.reflections.util.ClasspathHelper;
import org.geminicraft.betterwitch.reflections.util.ConfigurationBuilder;
import org.geminicraft.betterwitch.witches.model.GoalsInterface;
import org.mineacademy.fo.Common;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked cast")
public class GoalAdder {

    protected final Map<String, Class<? extends GoalsInterface>> goals = new ConcurrentHashMap<>();

    public GoalAdder() {
        Reflections tests = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("org.geminicraft.betterwitch.witches.model"))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));

        Set<Class<?>> classes = tests.getTypesAnnotatedWith(AIGoalsAnnotation.class);

        for (Class<?> customClass : classes) {

            String name = customClass.getAnnotation(AIGoalsAnnotation.class).name();
            goals.put(name, (Class<? extends GoalsInterface>) customClass);
        }

    }

    // TODO Clean up method.
    public void addPathfinderGoals(EntityInsentient entity, List<String> goals) throws IllegalAccessException, InstantiationException {

        Common.log(goals + " goals");


        if (goals == null) {
            Common.log("Do we get null here");
            return;
        }

        for (String item : goals) {
            ParamsFileHandler paramsFileHandler = null;
            int priority = 0;
            String name;
            String[] splitItem = item.split(" ");
            if (splitItem[0].matches("[0-9]*")) {
                priority = Integer.parseInt(splitItem[0]);
            } else {
                Common.log("*ERROR*");
            }


            if (this.goals.containsKey(splitItem[1])) {
                Common.log("Or do we enter");
                name = splitItem[1];
                Class<? extends GoalsInterface> customClass = this.goals.get(name);

                if (item.length() == 3) {
                    paramsFileHandler = new ParamsFileHandler(item.toLowerCase());
                }


                try {
                    Common.log("Please work");
                    GoalsInterface testInterfaceItem = customClass.getConstructor(new Class[]{EntityInsentient.class, ParamsFileHandler.class}).
                            newInstance(entity, new ParamsFileHandler(item.toLowerCase()));
                    entity.goalSelector.a(priority, testInterfaceItem.create());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                Common.log("We made an oopsie.");
            }

        }

        // TODO Uncomment when code for complexer path finders is finished
//        selectPathfinder("followPlayer", entity, 0);

    }


    /*
        This method has a switch statement for the moment. It's an intentional design
        that will be replaced later.
     */
    public void selectPathfinder(String name, EntityInsentient entityInsentient, int priority) {
        Common.log(name + " name bit");
        switch (name) {
            case "followPlayer":
                entityInsentient.goalSelector.a(priority, new PathfinderGoalTest(entityInsentient, 1.0, 5f));
                System.out.println("this works!");
        }


    }

    @Deprecated // Only exists for testing purposes, to be deleted soon.
    public void addPathfinderGoals(int index, EntityInsentient entity, PathfinderGoal goal) throws IllegalAccessException, InstantiationException {
        String name = "meleeAttack";

        Common.log(goals.toString() + " things in goals");

        if (this.goals.containsKey(name)) {
            Class<? extends GoalsInterface> customClass = this.goals.get(name);
            String x = "xx";
            GoalsInterface test = customClass.newInstance();
            Common.log(test.getClass().getName() + " just to verify this name also works");


            Common.log(customClass.getName() + " this is a name see what happens");


            PathfinderGoalSelector goals = entity.goalSelector;


            Common.log(goals.getClass().getName() + " got myself some goals");

            try {

                Common.log(goals.getClass().getField("c").get(goals) + " is this going to do anything");

                Common.log(goals.toString() + " list of goals I guessxxx");

                goals.a(index, test.create());


                goals.d().forEach((item) -> {
                    Common.log(item.toString() + " i am wondering what this is");
                });


                Common.log(goals.toString() + " list of goals I guess2");


            } catch (Exception e) {
                Common.log(e.getMessage());
                Common.log("Fuck knows what went wrong tbh");
            }
        }
    }


}