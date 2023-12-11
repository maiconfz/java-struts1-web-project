package com.my_app.page.company.save.service;

import javax.servlet.http.HttpServletRequest;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

/**
 * The UserSaveService interface defines methods for validating, saving, initializing,
 * and setting request attributes for user data.
 */
public interface CompanySaveService {
	
	/**
     * Validates the provided UserSaveForm.
     *
     * @param form The UserSaveForm to be validated.
     * @return true if the form is valid, false otherwise.
     */
	public boolean validate(CompanySaveForm form);

	/**
     * Saves the user data from the provided UserSaveForm.
     *
     * @param form The UserSaveForm containing user data to be saved.
     * @return The saved User instance.
     */
	public Company saveCompany(CompanySaveForm form);

	/**
     * Initializes the provided UserSaveForm, setting default values or performing
     * any necessary setup.
     *
     * @param form The UserSaveForm to be initialized.
     */
	public void formInit(CompanySaveForm form);

	/**
     * Sets request attributes based on the provided UserSaveForm for further processing
     * in the servlet or controller.
     *
     * @param form The UserSaveForm containing data to set request attributes.
     * @param req  The HttpServletRequest to which attributes will be set.
     */
	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req);
}