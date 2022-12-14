package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Factory class of a criteria validator
 */
public class ValueValidatorFactory {
    private static final ValueValidatorFactory instance = new ValueValidatorFactory();

    private final Map<List<String>, ValueValidator> validators = new HashMap<List<String>, ValueValidator>();

    /**
     * Gets the instance of a factory
     * @return instance of a factory
     */
    public static ValueValidatorFactory getInstance(){
        return instance;
    }

    /**
     * Gets the correct validator for a specific search criteria
     * @param searchCriteria search criteria to get validator for
     * @return validator for croteria or null if criteria is invalid
     */
    public ValueValidator getValidator(String searchCriteria){

        for (var entry: validators.entrySet()){
            var key = entry.getKey();
            var value = entry.getValue();

            if (key.contains(searchCriteria))
                return value;
        }
        return null;
    }

    /**
     * Instantiates a map of search criteria to allowed search type and value validator
     */
    private ValueValidatorFactory(){

        // Integer parameters
        validators.put(List.of(SearchCriteria.Oven.POWER_CONSUMPTION.name(),
                SearchCriteria.Oven.WEIGHT.name(),
                SearchCriteria.Oven.CAPACITY.name(),
                SearchCriteria.Oven.DEPTH.name(),

                SearchCriteria.Laptop.MEMORY_ROM.name(),
                SearchCriteria.Laptop.SYSTEM_MEMORY.name(),
                SearchCriteria.Laptop.DISPLAY_INCHS.name(),

                SearchCriteria.Refrigerator.POWER_CONSUMPTION.name(),
                SearchCriteria.Refrigerator.WEIGHT.name(),
                SearchCriteria.Refrigerator.FREEZER_CAPACITY.name(),
                SearchCriteria.Refrigerator.HEIGHT.name(),
                SearchCriteria.Refrigerator.WIDTH.name(),

                SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.name(),
                SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.name(),
                SearchCriteria.VacuumCleaner.CLEANING_WIDTH.name(),

                SearchCriteria.TabletPC.BATTERY_CAPACITY.name(),
                SearchCriteria.TabletPC.DISPLAY_INCHES.name(),
                SearchCriteria.TabletPC.MEMORY_ROM.name(),
                SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.name(),

                SearchCriteria.Speakers.POWER_CONSUMPTION.name(),
                SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name(),
                SearchCriteria.Speakers.CORD_LENGTH.name()
                ),
                new IntValidator());

        // Double parameters
        validators.put(List.of(
                SearchCriteria.Oven.HEIGHT.name(),
                SearchCriteria.Oven.WIDTH.name(),

                SearchCriteria.Laptop.BATTERY_CAPACITY.name(),
                SearchCriteria.Laptop.CPU.name(),

                SearchCriteria.Refrigerator.OVERALL_CAPACITY.name()
        ), new DoubleValidator());

        // String parameters
        validators.put(List.of(
                SearchCriteria.Laptop.OS.name(),

                SearchCriteria.VacuumCleaner.BAG_TYPE.name(),
                SearchCriteria.VacuumCleaner.WAND_TYPE.name()
        ), new StringValidator());

        // Filter type parameters
        validators.put(List.of(
                SearchCriteria.VacuumCleaner.FILTER_TYPE.name()
        ), new FilterTypeValidator());

        // Color parameters
        validators.put(List.of(
                SearchCriteria.TabletPC.COLOR.name()
        ), new ColorValidator());

        // Range parameters
        validators.put(List.of(
                SearchCriteria.Speakers.FREQUENCY_RANGE.name()
        ), new RangeValidator());
    }
}
