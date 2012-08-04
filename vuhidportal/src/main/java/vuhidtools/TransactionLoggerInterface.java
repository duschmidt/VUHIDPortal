/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
 package vuhidtools;

 /**
 * @author Phan Duy Long
 * log: type - VUHID transaction number from 1 to 9; previous_transaction - ID of the previous related transaction,
 * 		there also an overloaded function which does not take previous_transaction; values is the list of inputs (from left to right) then the output,
 * 		for example VUHID transaction 5: values[0] is the VUHID ID, values[1] is the reason, values[2] is the returned status code.
 * 		Returns the transaction row ID (in database).
 * setTransactionCompleted: set the input transaction row ID's (ID is returned by log) status to Completed
 */
public interface TransactionLoggerInterface
{
	public int log(int type, int previous_transaction, String[] values); // type - VUHID transaction number from 1 to 9, previous_transaction - ID of the previous related transaction,
	public int log(int type, String[] values); // overload function without a previous transaction
	public void setTransactionCompleted(int ID);
}
