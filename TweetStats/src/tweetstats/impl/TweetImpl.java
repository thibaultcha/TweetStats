/**
 */
package tweetstats.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tweetstats.Fetch;
import tweetstats.Tweet;
import tweetstats.TweetstatsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tweet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tweetstats.impl.TweetImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link tweetstats.impl.TweetImpl#getDate <em>Date</em>}</li>
 *   <li>{@link tweetstats.impl.TweetImpl#getId <em>Id</em>}</li>
 *   <li>{@link tweetstats.impl.TweetImpl#getFetch <em>Fetch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TweetImpl extends MinimalEObjectImpl.Container implements Tweet {
	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFetch() <em>Fetch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFetch()
	 * @generated
	 * @ordered
	 */
	protected Fetch fetch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TweetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TweetstatsPackage.Literals.TWEET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.TWEET__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.TWEET__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.TWEET__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fetch getFetch() {
		if (fetch != null && fetch.eIsProxy()) {
			InternalEObject oldFetch = (InternalEObject)fetch;
			fetch = (Fetch)eResolveProxy(oldFetch);
			if (fetch != oldFetch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TweetstatsPackage.TWEET__FETCH, oldFetch, fetch));
			}
		}
		return fetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fetch basicGetFetch() {
		return fetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFetch(Fetch newFetch, NotificationChain msgs) {
		Fetch oldFetch = fetch;
		fetch = newFetch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TweetstatsPackage.TWEET__FETCH, oldFetch, newFetch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFetch(Fetch newFetch) {
		if (newFetch != fetch) {
			NotificationChain msgs = null;
			if (fetch != null)
				msgs = ((InternalEObject)fetch).eInverseRemove(this, TweetstatsPackage.FETCH__RESULTS, Fetch.class, msgs);
			if (newFetch != null)
				msgs = ((InternalEObject)newFetch).eInverseAdd(this, TweetstatsPackage.FETCH__RESULTS, Fetch.class, msgs);
			msgs = basicSetFetch(newFetch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.TWEET__FETCH, newFetch, newFetch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__FETCH:
				if (fetch != null)
					msgs = ((InternalEObject)fetch).eInverseRemove(this, TweetstatsPackage.FETCH__RESULTS, Fetch.class, msgs);
				return basicSetFetch((Fetch)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__FETCH:
				return basicSetFetch(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__MESSAGE:
				return getMessage();
			case TweetstatsPackage.TWEET__DATE:
				return getDate();
			case TweetstatsPackage.TWEET__ID:
				return getId();
			case TweetstatsPackage.TWEET__FETCH:
				if (resolve) return getFetch();
				return basicGetFetch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__MESSAGE:
				setMessage((String)newValue);
				return;
			case TweetstatsPackage.TWEET__DATE:
				setDate((Date)newValue);
				return;
			case TweetstatsPackage.TWEET__ID:
				setId((Long)newValue);
				return;
			case TweetstatsPackage.TWEET__FETCH:
				setFetch((Fetch)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case TweetstatsPackage.TWEET__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TweetstatsPackage.TWEET__ID:
				setId(ID_EDEFAULT);
				return;
			case TweetstatsPackage.TWEET__FETCH:
				setFetch((Fetch)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TweetstatsPackage.TWEET__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case TweetstatsPackage.TWEET__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TweetstatsPackage.TWEET__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TweetstatsPackage.TWEET__FETCH:
				return fetch != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (message: ");
		result.append(message);
		result.append(", date: ");
		result.append(date);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //TweetImpl
