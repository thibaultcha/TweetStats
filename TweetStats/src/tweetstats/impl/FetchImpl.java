/**
 */
package tweetstats.impl;

import java.util.Collection;
import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import tweetstats.Fetch;
import tweetstats.Tweet;
import tweetstats.TweetstatsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fetch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tweetstats.impl.FetchImpl#getDate <em>Date</em>}</li>
 *   <li>{@link tweetstats.impl.FetchImpl#getLast_id <em>Last id</em>}</li>
 *   <li>{@link tweetstats.impl.FetchImpl#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FetchImpl extends MinimalEObjectImpl.Container implements Fetch {
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
	 * The default value of the '{@link #getLast_id() <em>Last id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast_id()
	 * @generated
	 * @ordered
	 */
	protected static final Long LAST_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLast_id() <em>Last id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLast_id()
	 * @generated
	 * @ordered
	 */
	protected Long last_id = LAST_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Tweet> results;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FetchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TweetstatsPackage.Literals.FETCH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.FETCH__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getLast_id() {
		return last_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLast_id(Long newLast_id) {
		Long oldLast_id = last_id;
		last_id = newLast_id;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TweetstatsPackage.FETCH__LAST_ID, oldLast_id, last_id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tweet> getResults() {
		if (results == null) {
			results = new EObjectWithInverseResolvingEList<Tweet>(Tweet.class, this, TweetstatsPackage.FETCH__RESULTS, TweetstatsPackage.TWEET__FETCH);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TweetstatsPackage.FETCH__RESULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResults()).basicAdd(otherEnd, msgs);
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
			case TweetstatsPackage.FETCH__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
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
			case TweetstatsPackage.FETCH__DATE:
				return getDate();
			case TweetstatsPackage.FETCH__LAST_ID:
				return getLast_id();
			case TweetstatsPackage.FETCH__RESULTS:
				return getResults();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TweetstatsPackage.FETCH__DATE:
				setDate((Date)newValue);
				return;
			case TweetstatsPackage.FETCH__LAST_ID:
				setLast_id((Long)newValue);
				return;
			case TweetstatsPackage.FETCH__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends Tweet>)newValue);
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
			case TweetstatsPackage.FETCH__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TweetstatsPackage.FETCH__LAST_ID:
				setLast_id(LAST_ID_EDEFAULT);
				return;
			case TweetstatsPackage.FETCH__RESULTS:
				getResults().clear();
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
			case TweetstatsPackage.FETCH__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TweetstatsPackage.FETCH__LAST_ID:
				return LAST_ID_EDEFAULT == null ? last_id != null : !LAST_ID_EDEFAULT.equals(last_id);
			case TweetstatsPackage.FETCH__RESULTS:
				return results != null && !results.isEmpty();
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
		result.append(" (date: ");
		result.append(date);
		result.append(", last_id: ");
		result.append(last_id);
		result.append(')');
		return result.toString();
	}

} //FetchImpl
