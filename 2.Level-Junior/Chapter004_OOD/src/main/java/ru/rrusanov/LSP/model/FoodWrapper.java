package ru.rrusanov.LSP.model;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.06.2019
 * <p>
 * The class wrapper food class add new behavior field canReproduct.
 */
public abstract class FoodWrapper extends Food {
    /**
     * The field contain info may this food reproduct after it's expire date is gone.
     */
    private boolean canReproduct;
    /**
     * The getter for field.
     * @return boolean.
     */
    public boolean isCanReproduct() {
        return this.canReproduct;
    }
}
