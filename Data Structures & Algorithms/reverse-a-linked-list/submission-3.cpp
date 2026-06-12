/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
            return head;

        ListNode* prev = head;
        ListNode* current = head->next;
        ListNode* next = head->next->next;

        // for first node, link it to null
        prev->next = nullptr; 
        
        while(current != nullptr){
            current->next = prev;

            ListNode* temp = current;

            prev = current;
            current = next;

            if (next != nullptr)
                next = next->next;
        }

        return prev;
    }
};
